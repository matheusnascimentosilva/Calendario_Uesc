package codes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Layout extends Meses {

	private JFrame frmCalendrioUesc;

	/**
	 * ABRINDO A APLICAÇÃO
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Layout window = new Layout();
					window.frmCalendrioUesc.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * CRIANDO A APLICAÇÃO
	 */
	public Layout() {
		@SuppressWarnings("unused")
		meu_Tema aplica = new meu_Tema();
		meu_Tema.AplicaNimbus();
		iniciando();
	}

	/**
	 * INICIALIZANDO A CONEXÃO COM A JANELA
	 */
	private void iniciando() {
		frmCalendrioUesc = new JFrame();
		frmCalendrioUesc.setResizable(false);
		frmCalendrioUesc.setAutoRequestFocus(false);
		frmCalendrioUesc.setTitle("CALEND\u00C1RIO UESC");
		frmCalendrioUesc.setBounds(100, 100, 900, 550);
		frmCalendrioUesc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// linha que seta o layout com ajuste livre
		frmCalendrioUesc.getContentPane().setLayout(null);

		JPanel painel_ano_mes = new JPanel();
		painel_ano_mes.setBackground(Color.LIGHT_GRAY);
		painel_ano_mes.setBounds(6, 6, 872, 50);
		frmCalendrioUesc.getContentPane().add(painel_ano_mes);
		painel_ano_mes.setLayout(null);

		JButton botao_prev_ano = new JButton("");
		botao_prev_ano.setBackground(new Color(255, 255, 255));
		botao_prev_ano.setIcon(
				new ImageIcon("C:\\Users\\Matheus\\eclipse-workspace\\Projeto LPIII\\src\\img\\botao_prev2.png"));
		botao_prev_ano.setFont(new Font("Impact", Font.PLAIN, 12));
		botao_prev_ano.setBounds(148, 6, 50, 38);
		painel_ano_mes.add(botao_prev_ano);

		JButton botao_prev_mes = new JButton("");
		botao_prev_mes.setBackground(new Color(0, 0, 0));
		botao_prev_mes.setIcon(
				new ImageIcon("C:\\Users\\Matheus\\eclipse-workspace\\Projeto LPIII\\src\\img\\botao_prev.png"));
		botao_prev_mes.setFont(new Font("Impact", Font.PLAIN, 12));
		botao_prev_mes.setBounds(210, 6, 50, 38);
		painel_ano_mes.add(botao_prev_mes);

		JButton botao_next_mes = new JButton("");
		botao_next_mes.setBackground(new Color(0, 0, 0));
		botao_next_mes.setIcon(
				new ImageIcon("C:\\Users\\Matheus\\eclipse-workspace\\Projeto LPIII\\src\\img\\botao_next.png"));
		botao_next_mes.setFont(new Font("Impact", Font.PLAIN, 12));
		botao_next_mes.setBounds(582, 6, 50, 38);
		painel_ano_mes.add(botao_next_mes);

		JButton botao_next_ano = new JButton("");
		botao_next_ano.setBackground(new Color(255, 255, 255));
		botao_next_ano.setIcon(
				new ImageIcon("C:\\Users\\Matheus\\eclipse-workspace\\Projeto LPIII\\src\\img\\botao_next2.png"));
		botao_next_ano.setFont(new Font("Impact", Font.PLAIN, 12));
		botao_next_ano.setBounds(644, 6, 50, 38);
		painel_ano_mes.add(botao_next_ano);

		JPanel painel_dias = new JPanel();
		painel_dias.setBackground(Color.LIGHT_GRAY);
		painel_dias.setBounds(146, 68, 572, 328);
		frmCalendrioUesc.getContentPane().add(painel_dias);
		painel_dias.setLayout(new BorderLayout(0, 0));

		JPanel eventos_dia = new JPanel();
		eventos_dia.setBackground(new Color(192, 192, 192));
		eventos_dia.setBounds(146, 418, 572, 71);
		frmCalendrioUesc.getContentPane().add(eventos_dia);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(730, 68, 148, 328);
		frmCalendrioUesc.getContentPane().add(panel);

		JButton lista_eventos = new JButton("LISTAR EVENTOS");
		lista_eventos.setForeground(new Color(255, 255, 255));
		lista_eventos.setBackground(new Color(0, 128, 0));
		lista_eventos.setBounds(730, 420, 137, 28);
		frmCalendrioUesc.getContentPane().add(lista_eventos);

		JButton botao_sair = new JButton("");
		botao_sair.setToolTipText("SAIR");
		botao_sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		botao_sair.setForeground(new Color(255, 255, 255));
		botao_sair.setBackground(new Color(128, 0, 0));
		botao_sair.setIcon(
				new ImageIcon("C:\\Users\\Matheus\\eclipse-workspace\\Projeto LPIII\\src\\img\\botao_exit.png"));
		botao_sair.setBounds(753, 460, 90, 38);
		frmCalendrioUesc.getContentPane().add(botao_sair);
	}

}
