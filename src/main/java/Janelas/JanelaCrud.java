package Janelas;

import Logradouro.Logradouro;
import WebService.ClienteWS;
import bd.dbos.Loja;
import bd.daos.Lojas;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaCrud extends JFrame{
    private JTextField códigoLojaTextField;
    private JTextField txtCodigo;
    private JTextField nomeTextField;
    private JTextField txtNome;
    private JTextField txtCep;
    private JTextField númeroTextField;
    private JTextField txtNumero;
    private JTextField complementoTextField;
    private JTextField txtComplemento;
    private JTextField txtRua;
    private JTextField ruaTextField;
    private JTextField bairroTextField;
    private JTextField txtBairro;
    private JTextField cidadeTextField;
    private JTextField txtCidade;
    private JTextField estadoTextField;
    private JTextField txtEstado;
    private JTextField categoriaTextField;
    private JTextField txtCategoria;
    private JButton inserirButton;
    private JButton procurarButton;
    private JButton alterarButton;
    private JButton deletarButton;
    private JTextField txtQtdFunc;
    private JPanel rootPanel;
    private JTextField qtdFuncionáriosTextField;
    private JTextField telefoneTextField;
    private JTextField txtTelefone;
    private JTextField cepTextField;
    private JButton limparButton;
    private boolean cepValido = false;
    public JanelaCrud()
    {
        add(rootPanel);
        setSize(500, 500);
        setTitle("Loja crud");
        txtCep.setColumns(8);

        procurarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Loja loja = null;
                try
                {
                    if(!txtCodigo.getText().trim().equals(""))
                        loja = procurarLoja(Integer.parseInt(txtCodigo.getText()));
                    else
                        loja = procurarLoja(txtNome.getText());
                    enableAlterarDeletar(true);
                    exibirLoja(loja);
                    txtCodigo.setEditable(false);
                    inserirButton.setEnabled(false);
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
                try
                {
                    inserirLoja();
                    JOptionPane.showMessageDialog(rootPanel, "Inserido com sucesso!");
                    enableAlterarDeletar(true);
                    txtCodigo.setEditable(false);
                    inserirButton.setEnabled(false);
                }
                catch (Exception ex){
                    JOptionPane.showMessageDialog(rootPanel, ex.getMessage());
                }
            }
        });

        alterarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    alterarLoja(Integer.parseInt(txtCodigo.getText()));
                    JOptionPane.showMessageDialog(rootPanel, "Alterado com sucesso");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(rootPanel, ex.getMessage());
                }
            }
        });

        deletarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    deletarLoja();
                    JOptionPane.showMessageDialog(rootPanel, "Loja deletada");
                    limparCampos();
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(rootPanel, ex.getMessage());
                }
            }
        });

        txtCep.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                int length = txtCep.getText().length();
                if(length == 8)
                    fetchCep(txtCep.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                int length = txtCep.getText().length();
                if(length == 8)
                    fetchCep(txtCep.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                int length = txtCep.getText().length();
                if(length == 8)
                    fetchCep(txtCep.getText());
            }
        });


        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparCampos();
                txtCodigo.setEditable(true);
                inserirButton.setEnabled(true);
                enableAlterarDeletar(false);
            }
        });
    }

    private Loja newLojaInstance() throws Exception
    {
        return  new Loja(txtNome.getText(), Integer.parseInt(txtCep.getText()), Integer.parseInt(txtNumero.getText()), txtComplemento.getText(),
                txtTelefone.getText(), txtCategoria.getText(), Integer.parseInt(txtQtdFunc.getText()));
    }

    private  void limparCampos()
    {
        txtCodigo.setText(null);
        txtNome.setText(null);
        txtCep.setText(null);
        txtNumero.setText(null);
        txtComplemento.setText(null);
        txtTelefone.setText(null);
        txtCategoria.setText(null);
        txtQtdFunc.setText(null);
        limparEndereco();
    }
    private void deletarLoja() throws Exception
    {
        Lojas.deletar(Integer.parseInt(txtCodigo.getText()));
    }

    private void alterarLoja(int cod) throws Exception
    {
        if(!this.cepValido)
            throw new Exception("Cep inválido");
        Loja loja = newLojaInstance();
        loja.setCodigo(cod);
        Lojas.alterar(loja);
    }

    private void inserirLoja() throws Exception
    {
        if(!this.cepValido)
            throw new Exception("Cep inválido");
        Loja loja = newLojaInstance();
        Lojas.incluir(loja);
        Loja lojaExb = procurarLoja(loja.getNome());
        exibirLoja(lojaExb);
    }

    private void fetchCep(String cep)
    {
        try {
            Logradouro log = (Logradouro) ClienteWS.getObjeto(Logradouro.class, "http://api.postmon.com.br/v1/cep", cep);
            alterarTxtEndereco(log);
            this.cepValido = true;
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPanel, "Cep inválido");
            limparEndereco();
            this.cepValido = false;
        }

    }

    private void alterarTxtEndereco(Logradouro log)
    {
        txtRua.setText(log.getLogradouro());
        txtBairro.setText(log.getBairro());
        txtCidade.setText(log.getCidade());
        txtEstado.setText(log.getEstado());
    }

    private void limparEndereco()
    {
        txtRua.setText(null);
        txtBairro.setText(null);
        txtCidade.setText(null);
        txtEstado.setText(null);
    }

    private Loja procurarLoja(int codigo) throws Exception
    {
        return Lojas.getLoja(codigo);
    }

    private Loja procurarLoja(String nome) throws Exception
    {
        return Lojas.getLoja(nome);
    }
    private void enableAlterarDeletar(boolean enable)
    {
        alterarButton.setEnabled(enable);
        deletarButton.setEnabled(enable);
    }

    private void exibirLoja(Loja loja)
    {
        txtCodigo.setText(loja.getCodigo()+"");
        txtNome.setText(loja.getNome());
        txtCep.setText(loja.getCep() + "");
        txtNumero.setText(loja.getNumero() + "");
        txtComplemento.setText(loja.getComplemento());
        txtTelefone.setText(loja.getTelefone());
        txtCategoria.setText(loja.getCategoria());
        txtQtdFunc.setText(loja.getQtdFuncionarios() + "");
    }
}
