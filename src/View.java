import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

class View extends JFrame {
    //Fields
    private Controller controller;

    private Map<JTextField, JLabel> mapSets = new HashMap<>();

    private JTextField textFieldSet1 = new JTextField("-7, -5, -1, 0, 1, 2, 3, 5, 9", 10);
    private JTextField textFieldSet2 = new JTextField("-7, -6, -5, -4, -1, 0, 2, 3, 5, 8", 10);
    private JTextField textFieldSet3 = new JTextField(10);//"-9, -7, -3, -1, 0, 2, 4, 5, 10",
    private JTextField textFieldSet4 = new JTextField(10);//"-7, -6, -4, 0, 1, 2, 3, 8",
    private JTextField textFieldSet5 = new JTextField(10);

    private JLabel labelField1 = new JLabel("                                               ");
    private JLabel labelField2 = new JLabel("                                               ");
    private JLabel labelField3 = new JLabel("                                               ");
    private JLabel labelField4 = new JLabel("                                               ");
    private JLabel labelField5 = new JLabel("                                               ");

    private JLabel labelResult = new JLabel("Результат пересечения подмножеств");

    JLabel fieldZ = new JLabel();

    JTextField fieldX = new JTextField(3);
    JLabel resultX = new JLabel();

    JButton buttonCalc = new JButton("Операция над множествами");
    JButton buttonfindX = new JButton("Найти X");

    //Constructor
    View(Controller controller) throws HeadlessException {
        this.controller = controller;

        mapSets.put(textFieldSet1, labelField1);
        mapSets.put(textFieldSet2, labelField2);
        mapSets.put(textFieldSet3, labelField3);
        mapSets.put(textFieldSet4, labelField4);
        mapSets.put(textFieldSet5, labelField5);

        initDisplay();
    }

    //Functions
    private void initDisplay() {
        setLayout(new GridBagLayout());

        addComponent(new JLabel("Введите элементы множества через запятую или пробел"), 0, 0, 2, 1);

        addComponent(new JLabel("A:"), 0, 1, 1, 1);
        addComponent(textFieldSet1, 1, 1, 1, 1);
        addComponent(labelField1, 2, 1, 1, 1);

        addComponent(new JLabel("B:"), 0, 2, 1, 1);
        addComponent(textFieldSet2, 1, 2, 1, 1);
        addComponent(labelField2, 2, 2, 1, 1);

        addComponent(new JLabel("C:"), 0, 3, 1, 1);
        addComponent(textFieldSet3, 1, 3, 1, 1);
        addComponent(labelField3, 2, 3, 1, 1);

        addComponent(new JLabel("D:"), 0, 4, 1, 1);
        addComponent(textFieldSet4, 1, 4, 1, 1);
        addComponent(labelField4, 2, 4, 1, 1);

        addComponent(new JLabel("E:"), 0, 5, 1, 1);
        addComponent(textFieldSet5, 1, 5, 1, 1);
        addComponent(labelField5, 2, 5, 1, 1);

        buttonCalc.addActionListener(controller);
        addComponent(buttonCalc, 1, 6, 1, 1);

        labelResult.setForeground(Color.blue);
        addComponent(labelResult, 4, 0, 2, 1);
        addComponent(new JLabel("Z:"), 4, 1, 1, 1);
        fieldZ.setForeground(new Color(0, 170, 0));
        addComponent(fieldZ, 5, 1, 1, 1);

        addComponent(new JLabel("Задайте число:"), 4, 2, 2, 1);
        addComponent(new JLabel("x:"), 4, 3, 1, 1);
        addComponent(fieldX, 5, 3, 1, 1);
        addComponent(new JLabel("Результат совпадения:"), 4, 4, 2, 1);
        resultX.setForeground(new Color(0, 170, 0));
        addComponent(resultX, 5, 5, 1, 1);
        buttonfindX.addActionListener(controller);
        addComponent(buttonfindX, 5, 6, 1, 1);

        setTitle("Множества");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(700, 300);
        setLocationRelativeTo(null);
        pack();
        setResizable(false);
        setVisible(true);
    }

    private void addComponent(Component component, int gridx, int gridy, int gridwidth, int gridheight) {
        add(component, new GridBagConstraints(gridx, gridy, gridwidth, gridheight, 0, 0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
    }

    Map<JTextField, JLabel> getMapSets() {
        return mapSets;
    }
}
