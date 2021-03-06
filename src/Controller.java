import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

class Controller extends JPanel implements ActionListener {
    //Fields
    private Model model;
    private View view;

    //Constructor
    Controller(Model model) {
        this.model = model;
        view = new View(this);
    }

    //Functions
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(view.buttonCalc.getText())) {
            //Кнопка Операция над множествами
            findSets();
        } else if (e.getActionCommand().equals(view.buttonfindX.getText())) {
            //Кнопка Найти X
            findX();
        }
    }

    private void findSets() {
        String line;

        //Прохождение по карте для добавления данных в Set
        for (Map.Entry<JTextField, JLabel> map : view.getMapSets().entrySet()) {
            //Установка в JLabel пустого поля
            map.getValue().setText("                                               ");

            line = map.getKey().getText();
            if (line == null || line.length() == 0 || line.equals("")) continue;

            //Проверка на валидность введенных данных
            try {
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
    }

    private void findX() {
        int x = 0;

        try {
            x = Integer.parseInt(view.fieldX.getText().trim());
        } catch (NumberFormatException e1) {
            JOptionPane.showMessageDialog(this, "Некорректный ввод! Введите число!", "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
        //Установка результата в поле X
        view.resultX.setText(model.findX(x));
    }
}
