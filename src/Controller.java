import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class Controller implements ActionListener {
    //Fields
    private Model model;
    private View view;

    //Constructor
    public Controller(Model model) {
        this.model = model;
        view = new View(this);
    }

    //Functions
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(view.buttonCalc.getText())) {
            String line;

            for (Map.Entry<JTextField, JLabel> map : view.getMapSets().entrySet()) {
                try {
                    map.getValue().setText("                                               ");
                    line = map.getKey().getText();

                    if (line == null || line.length() == 0 || line == "") continue;
                    if (line.contains(", ")) {
                        model.addSet(line.trim().split(", "));
                    } else if (line.contains(" ")) {
                        model.addSet(line.trim().split(" "));
                    } else if (line.contains(",")) {
                        model.addSet(line.trim().split(","));
                    } else {
                        model.addSet(line.trim());
                    }

                } catch (NumberFormatException exc) {
                    map.getValue().setForeground(Color.RED);
                    map.getValue().setText("Некорректные данные!");
                    model.clearSets();
                    return;
                }
            }

            view.fieldZ.setText(model.crossSets());


        } else if (e.getActionCommand().equals(view.buttonfindX.getText())) {

        }
    }
}
