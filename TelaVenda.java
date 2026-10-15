package com.mycompany.comercio;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TelaVenda extends JFrame {

    private JTextArea area;
    private VendaConect dao = new VendaConect();

    private final Object[][] PRODUTOS = {
        {"Notebook", 1, 3500.00},
        {"Mouse", 2, 150.00},
        {"Teclado Mecânico", 3, 250.00}
    };

    private List<JCheckBox> checkboxes = new ArrayList<>();

    // Construtor: inicializa o objeto com os metódos criados 
    public TelaVenda() {
        configurarJanela();
        adicionarPainelProdutos();
        adicionarAreaResultado();
        adicionarPainelBotoes();
    }

    // Configura as propriedades da janela
    private void configurarJanela() {
        setTitle("Sistema de Vendas - Grupo 4");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(173, 216, 230)); 
    }

    // Monta o painel com os checkboxes dos produtos
    private void adicionarPainelProdutos() {
        JPanel painelProdutos = new JPanel(new GridLayout(3, 1, 5, 5));
        painelProdutos.setBorder(BorderFactory.createTitledBorder("Selecione os produtos"));

        for (Object[] p : PRODUTOS) {
            String texto = p[0] + " - " + p[1] + "x - R$ " + p[2];
            JCheckBox cb = new JCheckBox(texto);
            checkboxes.add(cb);
            painelProdutos.add(cb);
            painelProdutos.setBackground(new Color(173, 216, 230));
            cb.setBackground(new Color(173, 216, 230));
            cb.setOpaque(true);
        }

        add(painelProdutos, BorderLayout.NORTH);
    }

    // Monta a área de texto de resultado
    private void adicionarAreaResultado() {
        area = new JTextArea();
        area.setEditable(false);
        area.setFont(new Font("Monospaced", Font.PLAIN, 13));
        add(new JScrollPane(area), BorderLayout.CENTER);
        area.setBackground(new Color(173, 216, 230));
    }

    // Monta o painel com os botões e suas ações
    private void adicionarPainelBotoes() {
        JPanel painel = new JPanel();

        JButton btnInserir = new JButton("Inserir Venda");
        JButton btnTotal = new JButton("Mostrar Total (SUM)");
        JButton btnLimpar = new JButton("Limpar");

        painel.add(btnInserir);
        painel.add(btnTotal);
        painel.add(btnLimpar);
        add(painel, BorderLayout.SOUTH);
        painel.setBackground(new Color(173, 216, 230));

        btnInserir.addActionListener(e -> inserirSelecionados());
        btnTotal.addActionListener(e -> mostrarTotal());
        btnLimpar.addActionListener(e -> limpar());
    }

    // Insere os produtos selecionados e mostra o resultado
    private void inserirSelecionados() {
        try {
            int quantidadeInserida = inserirProdutosSelecionados();
            mostrarResultadoInsercao(quantidadeInserida);
        } catch (SQLException msg_erro) {
            JOptionPane.showMessageDialog(this, "Erro: " + msg_erro.getMessage());
        }
    }

    // Percorre os checkboxes e insere os selecionados
    private int inserirProdutosSelecionados() throws SQLException {
        int contador = 0;

        for (int i = 0; i < checkboxes.size(); i++) {
            if (checkboxes.get(i).isSelected()) {
                inserirProduto(i);
                contador++;
            }
        }

        return contador;
    }

    // Insere um produto no banco
    private void inserirProduto(int indice) throws SQLException {
        Object[] p = PRODUTOS[indice];

        Venda v = new Venda(
            (String) p[0],
            (int) p[1],
            (double) p[2]
        );

        dao.inserir(v);
        area.append("-> Inserido: " + p[0] + "\n");
    }

    // Mostra a mensagem final da inserção
    private void mostrarResultadoInsercao(int quantidade) {
        if (quantidade == 0) {
            area.append("[ ! ] Nenhum produto selecionado.\n");
        } else {
            area.append("----------------------------------------\n");
        }
    }

    // Mostra o total geral das vendas
    private void mostrarTotal() {
        try {
            double total = dao.somarTotal();
            area.append("==> Total geral das vendas: R$ " + total + "\n");
        } catch (SQLException msg_erro) {
            JOptionPane.showMessageDialog(this, "Erro: " + msg_erro.getMessage());
        }
    }

    // Limpa a tela e, se confirmado, apaga o banco
    private void limpar() {
        boolean apagarBanco = perguntarSeApagaBanco();

        desmarcarCheckboxes();
        limparAreaTexto();

        if (apagarBanco) {
            apagarVendasDoBanco();
        }
    }

    // Pergunta ao usuário se quer apagar o banco também
    private boolean perguntarSeApagaBanco() {
        int resposta = JOptionPane.showConfirmDialog(
            this,
            "Deseja apagar TODAS as vendas do carrinho de compras também?",
            "Confirmar limpeza",
            JOptionPane.YES_NO_OPTION
        );
        return resposta == JOptionPane.YES_OPTION;
    }

    // Desmarca todos os checkboxes
    private void desmarcarCheckboxes() {
        for (JCheckBox cb : checkboxes) {
            cb.setSelected(false);
        }
    }

    // Limpa a área de texto
    private void limparAreaTexto() {
        area.setText("");
    }

    // Apaga as vendas do banco
    private void apagarVendasDoBanco() {
        try {
            dao.limparVendas();
            area.append("-> Todas as vendas foram apagadas do carrinho .\n");
        } catch (SQLException msg_erro) {
            JOptionPane.showMessageDialog(this, "[ ! ]Erro ao limpar o carrinho  : " + msg_erro.getMessage());
        }
    }
}