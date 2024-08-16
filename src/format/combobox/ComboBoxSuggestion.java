package format.combobox;


import javax.swing.*;

public class ComboBoxSuggestion<E> extends JComboBox<E> {

        public ComboBoxSuggestion() {
            setUI(new ComboSuggestionUI());
        }
}
