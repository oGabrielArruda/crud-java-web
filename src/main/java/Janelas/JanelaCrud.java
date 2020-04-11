package Janelas;

import bd.dbos.Loja;
import bd.daos.Lojas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaCrud extends JFrame{
    private JTextField códigoLojaTextField;
    private JTextField txtCodigo;
    private JTextField nomeTextField;
    private JTextField textField4;
    private JTextField cepTextField;
    private JTextField textField6;
    private JTextField númeroTextField;
    private JTextField textField8;
    private JTextField complementoTextField;
    private JTextField textField10;
    private JTextField textField11;
    private JTextField ruaTextField;
    private JTextField bairroTextField;
    private JTextField textField14;
    private JTextField cidadeTextField;
    private JTextField textField16;
    private JTextField estadoTextField;
    private JTextField textField18;
    private JTextField categoriaTextField;
    private JTextField textField20;
    private JButton inserirButton;
    private JButton procurarButton;
    private JButton alterarButton;
    private JButton deletarButton;
    private JTextField qtdFuncionáriosTextField;
    private JTextField textField3;
    private JPanel rootPanel;

    public JanelaCrud()
    {
        add(rootPanel);
        setSize(500, 500);
        setTitle("Loja crud");

        procurarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    Loja loja = procurarLoja(Integer.parseInt(txtCodigo.getText()));
                    alterarButton.setEnabled(true);
                    deletarButton.setEnabled(true);
                }
                catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(rootPanel, ex.getMessage());
                }
            }
        });

        inserirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
    }

    private Loja procurarLoja(int codigo) throws Exception
    {
        return Lojas.getLoja(codigo);
    }
}
