package format.chart;


import model.ChartModel;
import model.LegendModel;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Path2D;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CurveChart extends JPanel {
    DecimalFormat df = new DecimalFormat("#,##0.##");
    private List<LegendModel> legends = new ArrayList();
    private List<ChartModel> model = new ArrayList();
    private final Animator animator;
    private float animate;
    private BlankPlotChart blankPlotChart;
    private JPanel panelLegend;

    public CurveChart() {
        this.initComponents();
        this.setOpaque(false);
        TimingTarget target = new TimingTargetAdapter() {
            public void timingEvent(float fraction) {
               CurveChart.this.animate = fraction;
               CurveChart.this.repaint();
            }
        };
        this.animator = new Animator(800, target);
        this.animator.setResolution(0);
        this.animator.setAcceleration(0.5F);
        this.animator.setDeceleration(0.5F);
        this.blankPlotChart.getNiceScale().setMaxTicks(5);
        this.blankPlotChart.setBlankPlotChatRender(new BlankPlotChatRender() {
            public int getMaxLegend() {
                return CurveChart.this.legends.size();
            }

            public String getLabelText(int index) {
                return ((ChartModel) CurveChart.this.model.get(index)).getLabel();
            }

            public void renderSeries(BlankPlotChart chart, Graphics2D g2, SeriesSize size, int index) {
            }

            public void renderSeries(BlankPlotChart chart, Graphics2D g2, SeriesSize size, int index, List<Path2D.Double> gra) {
                for(int i = 0; i < CurveChart.this.legends.size(); ++i) {
                    double x = size.getX() + size.getWidth() / 2.0;
                    double ys;
                    double xs;
                    if (index == 0) {
                        ys = chart.getSeriesValuesOf(0.0, size.getHeight()) * (double) CurveChart.this.animate;
                        ys = size.getY() + size.getHeight() - ys;
                        xs = x - size.getWidth() / 2.0;
                    } else {
                        ys = chart.getSeriesValuesOf(((ChartModel) CurveChart.this.model.get(index - 1)).getValues()[i], size.getHeight()) * (double) CurveChart.this.animate;
                        ys = size.getY() + size.getHeight() - ys;
                        xs = x - size.getWidth();
                    }

                    double s = xs + size.getWidth() / 4.0;
                    double seriesValues = chart.getSeriesValuesOf(((ChartModel) CurveChart.this.model.get(index)).getValues()[i], size.getHeight()) * (double) CurveChart.this.animate;
                    double yy = size.getY() + size.getHeight() - seriesValues;
                    ((Path2D.Double)gra.get(i)).append(new CubicCurve2D.Double(xs, ys, s, ys, s, yy, x, yy), true);
                    if (index == chart.getLabelCount() - 1) {
                        ys = yy;
                        s = x + size.getWidth() / 4.0;
                        seriesValues = chart.getSeriesValuesOf(0.0, size.getHeight()) * (double) CurveChart.this.animate;
                        yy = size.getY() + size.getHeight() - seriesValues;
                        ((Path2D.Double)gra.get(i)).append(new CubicCurve2D.Double(x, ys, s, ys, s, yy, x + size.getWidth() / 2.0, yy), true);
                    }
                }

            }

            public void renderGraphics(Graphics2D g2, List<Path2D.Double> gra) {
                g2.setStroke(new BasicStroke(3.0F, 1, 0));

                for(int i = 0; i < gra.size(); ++i) {
                    Color c = ((LegendModel) CurveChart.this.legends.get(i)).getColorLight();
                    g2.setPaint(new GradientPaint(0.0F, 0.0F, ((LegendModel) CurveChart.this.legends.get(i)).getColor(), 0.0F, (float) CurveChart.this.getHeight(), new Color(c.getRed(), c.getGreen(), c.getBlue(), 0)));
                    g2.setComposite(AlphaComposite.getInstance(3, 0.7F));
                    g2.fill((Shape)gra.get(i));
                    g2.setPaint(new GradientPaint(0.0F, 0.0F, ((LegendModel) CurveChart.this.legends.get(i)).getColor(), (float) CurveChart.this.getWidth(), 0.0F, ((LegendModel) CurveChart.this.legends.get(i)).getColorLight()));
                    g2.setComposite(AlphaComposite.getInstance(3, 1.0F));
                    g2.draw((Shape)gra.get(i));
                }

            }

            public boolean mouseMoving(BlankPlotChart chart, MouseEvent evt, Graphics2D g2, SeriesSize size, int index) {
                return false;
            }
        });
    }

    public void addLegend(String name, Color color, Color color1) {
        LegendModel data = new LegendModel(name, color, color1);
        this.legends.add(data);
        this.panelLegend.add(new LegendItem(data));
        this.panelLegend.repaint();
        this.panelLegend.revalidate();
    }

    public void addData(ChartModel data) {
        this.model.add(data);
        this.blankPlotChart.setLabelCount(this.model.size());
        double max = data.getMaxValues();
        if (max > this.blankPlotChart.getMaxValues()) {
            this.blankPlotChart.setMaxValues(max);
        }

    }

    public void clear() {
        this.animate = 0.0F;
        this.blankPlotChart.setLabelCount(0);
        this.model.clear();
        this.repaint();
    }

    public void start() {
        if (!this.animator.isRunning()) {
            this.animator.start();
        }

    }

    private void initComponents() {
        this.blankPlotChart = new BlankPlotChart();
        this.panelLegend = new JPanel();
        this.setBackground(new Color(255, 255, 255));
        this.panelLegend.setOpaque(false);
        this.panelLegend.setLayout(new FlowLayout(1, 5, 0));
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).
                addGroup(layout.createSequentialGroup().
                        addContainerGap().
                        addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).
                                addComponent(this.panelLegend, -1, 573, 32767).
                                addComponent(this.blankPlotChart, -1, -1, 32767)).
                        addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).
                addGroup(layout.createSequentialGroup().
                        addContainerGap().
                        addComponent(this.blankPlotChart, -1, 342, 32767).
                        addGap(0, 0, 0).
                        addComponent(this.panelLegend, -2, 28, -2).
                        addContainerGap()));
    }
}
