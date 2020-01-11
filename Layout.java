package codes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Layout {

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
		frmCalendrioUesc.setAutoRequestFocus(false);
		frmCalendrioUesc.setTitle("CALEND\u00C1RIO UESC");
		frmCalendrioUesc.setBounds(100, 100, 900, 500);
		frmCalendrioUesc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// linha que seta o layout com ajuste livre
		frmCalendrioUesc.getContentPane().setLayout(null);

		JPanel painel_ano_mes = new JPanel();
		painel_ano_mes.setBackground(Color.LIGHT_GRAY);
		painel_ano_mes.setBounds(6, 6, 872, 50);
		frmCalendrioUesc.getContentPane().add(painel_ano_mes);
		painel_ano_mes.setLayout(null);

		JButton botao_prev_ano = new JButton("<<");
		botao_prev_ano.setFont(new Font("Impact", Font.PLAIN, 12));
		botao_prev_ano.setBounds(148, 6, 50, 38);
		painel_ano_mes.add(botao_prev_ano);

		JButton botao_prev_mes = new JButton("<");
		botao_prev_mes.setFont(new Font("Impact", Font.PLAIN, 12));
		botao_prev_mes.setBounds(210, 6, 50, 38);
		painel_ano_mes.add(botao_prev_mes);

		JButton botao_next_mes = new JButton(">");
		botao_next_mes.setFont(new Font("Impact", Font.PLAIN, 12));
		botao_next_mes.setBounds(582, 6, 50, 38);
		painel_ano_mes.add(botao_next_mes);

		JButton botao_next_ano = new JButton(">>");
		botao_next_ano.setFont(new Font("Impact", Font.PLAIN, 12));
		botao_next_ano.setBounds(644, 6, 50, 38);
		painel_ano_mes.add(botao_next_ano);

		JLabel lblNewLabel = new JLabel("ANO");
		lblNewLabel.setFont(new Font("Impact", Font.PLAIN, 20));
		lblNewLabel.setBounds(311, 9, 105, 27);
		painel_ano_mes.add(lblNewLabel);

		JLabel lblMs = new JLabel("M\u00CAS");
		lblMs.setFont(new Font("Impact", Font.PLAIN, 20));
		lblMs.setBounds(465, 9, 105, 27);
		painel_ano_mes.add(lblMs);

		JPanel painel_dias = new JPanel();
		painel_dias.setBackground(Color.LIGHT_GRAY);
		painel_dias.setBounds(146, 68, 572, 328);
		frmCalendrioUesc.getContentPane().add(painel_dias);
		painel_dias.setLayout(new BorderLayout(0, 0));

		JButton lista_eventos = new JButton("LISTAR EVENTOS");
		lista_eventos.setBounds(730, 85, 137, 28);
		frmCalendrioUesc.getContentPane().add(lista_eventos);
	}
}
