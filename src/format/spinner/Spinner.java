package format.spinner;

import javax.swing.*;


public class Spinner extends JSpinner {


        public void setLabelText(String text) {
            SpinnerUI.Editor editor = (SpinnerUI.Editor) getEditor();
            editor.setLabelText(text);
        }

        public String getLabelText() {
            SpinnerUI.Editor editor = (SpinnerUI.Editor) getEditor();
            return editor.getLabelText();
        }

        public Spinner(SpinnerNumberModel numberModel) {
            setOpaque(false);
            setUI(new SpinnerUI());
        }

}
