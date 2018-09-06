import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    private static JButton ng = new JButton("Новая игра");
    private JButton ex = new JButton("Выход");

    private JRadioButton dif1 = new JRadioButton("Легко");
    private JRadioButton dif2 = new JRadioButton("Нормально");
    private JRadioButton dif3 = new JRadioButton("Сложно");

    private JRadioButton clr1 = new JRadioButton("Красная");
    private JRadioButton clr2 = new JRadioButton("Синяя");
    private JRadioButton clr3 = new JRadioButton("Зеленая");

    private final JLabel str = new JLabel("Выберите сложность игры: ");
    private final JLabel str2 = new JLabel("Выберите цвет змейки: ");

    public Menu() {
        super("Змейка");
        setSize(210, 260);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);

        Container container = this.getContentPane();
        ButtonGroup group = new ButtonGroup();
        group.add(dif1);
        group.add(dif2);
        group.add(dif3);
        dif1.setSelected(true);

        ButtonGroup clrGroup = new ButtonGroup();
        clrGroup.add(clr1);
        clrGroup.add(clr2);
        clrGroup.add(clr3);
        clr1.setSelected(true);

        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        container.add(ng);
        container.add(str);

        {
            container.add(dif1);
            container.add(dif2);
            container.add(dif3);
        }
        container.add(str2);
        {
            container.add(clr1);
            container.add(clr2);
            container.add(clr3);
        }
        container.add(ex);


        ng.addActionListener(new ButtonEventListener());
        ex.addActionListener(new ExitEventListener());
        dif1.addActionListener(new DifListener());
        dif2.addActionListener(new Dif2Listener());
        dif3.addActionListener(new Dif3Listener());
        clr1.addActionListener(new ClrListener());
        clr2.addActionListener(new Clr2Listener());
        clr3.addActionListener(new Clr3Listener());
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
    }
}

class ButtonEventListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Main.run();
    }
}

class ExitEventListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}

class DifListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Main.speed = 10;
        Main.different = 0;
    }
}

class Dif2Listener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Main.speed = 10;
        Main.different = 1;
    }
}

class Dif3Listener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Main.speed = 20;
        Main.different = 1;
    }
}

class ClrListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        Main.color=0;
    }
}
class Clr2Listener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        Main.color=1;
    }
}
class Clr3Listener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        Main.color=2;
    }
}