
//CLASSE PRINCIPAL RESPONSÁVEL POR DESENHAR OS ELEMNTOS NA TELA
package codes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class MeuCalendario extends JFrame implements ActionListener {
	private static final ArrayList<String> meses;
	//ARRAY DE MESES
	static {
		meses = new ArrayList<String>(12);
		meses.add("Janeiro");
		meses.add("Fevereiro");
		meses.add("Marco");
		meses.add("Abril");
		meses.add("Maio");
		meses.add("Junho");
		meses.add("Julho");
		meses.add("Agosto");
		meses.add("Setembro");
		meses.add("Outubro");
		meses.add("Novembro");
		meses.add("Dezembro");
	};
	private GregorianCalendar calendario;
	private JLabel labelmes;
	private JLabel labelano;
	private JPanel Paneldia;

	public MeuCalendario ( GregorianCalendar d) {
		Border loweredbevel;
		calendario = d;
		setLayout(new FlowLayout());
		JPanel painelMeses = new JPanel();
		JPanel painelAno = new JPanel();
		JButton[] buttons = new JButton[32];
		JButton sair = new JButton("Sair");
		JFrame janela = new JFrame();

		painelMeses.add(buttons[0] = new JButton("<<"));
		getBackground();
		buttons[0].setBackground(Color.BLUE);
		getForeground();
		buttons[0].setForeground(Color.WHITE);
		painelMeses.add(labelmes = new JLabel(String.valueOf(meses.get(calendario.get(GregorianCalendar.MONTH))), JLabel.CENTER));
		painelMeses.add(buttons[1] = new JButton(">>"));
		getBackground();
		buttons[1].setBackground(Color.BLUE);
		getForeground();
		buttons[1].setForeground(Color.WHITE);

		painelAno.add(buttons[2] = new JButton("<"));
		getBackground();
		buttons[2].setBackground(Color.BLUE);
		getForeground();
		buttons[2].setForeground(Color.WHITE);
		painelAno.add(labelano = new JLabel(String.valueOf(calendario.get(GregorianCalendar.YEAR)),JLabel.CENTER), BorderLayout.CENTER);
		painelAno.add(buttons[3] = new JButton(">"));
		getBackground();
		buttons[3].setBackground(Color.BLUE);
		getForeground();
		buttons[3].setForeground(Color.WHITE);

		TitledBorder titulo21 = null;
		loweredbevel = BorderFactory.createRaisedBevelBorder();
		titulo21 = BorderFactory.createTitledBorder(loweredbevel,"MÊS:");
		painelMeses.setBorder(titulo21);

		TitledBorder titulo22 = null;
		loweredbevel = BorderFactory.createRaisedBevelBorder();
		titulo22 = BorderFactory.createTitledBorder(loweredbevel,"ANO:");
		painelAno.setBorder(titulo22);

		for (int i=0; i<4; i++) {
			buttons[i].addActionListener(this);
		}
		getBackground();
		sair.setBackground(Color.RED);
		getForeground();
		sair.setForeground(Color.WHITE);

		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(5, 10, 0, 10));
		panel.add(painelMeses);
		panel.add(painelAno);
		panel.add(sair);
		Paneldia = new JPanel(new GridLayout(7, 7));
		updateDayGrid();
		add(panel, BorderLayout.NORTH);
		add(Paneldia, BorderLayout.CENTER);
		pack();
		setVisible(true);

		sair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});

	}

	public GregorianCalendar getCal () {
		return calendario;
	}
	public void actionPerformed (ActionEvent evt) {
		String label = ((JButton) evt.getSource()).getText();
		if (label.equals("<<")) {
			int m = meses.indexOf(labelmes.getText());
			m = prevMonth(m);
			labelmes.setText((String) meses.get(m));
			updateDayGrid();
		}
		else if (label.equals(">>")) {
			int m = meses.indexOf(labelmes.getText());
			m = nextMonth(m);
			labelmes.setText((String) meses.get(m));
			updateDayGrid();
		} 

		else if (label.equals("<")) {
			int y = 0;
			try {
				y = Integer.parseInt(labelano.getText());
			}
			catch (NumberFormatException e) {
				System.err.println(e.toString());
			}
			labelano.setText(String.valueOf(--y));
			updateDayGrid();
		}
		else if (label.equals(">")) {
			int y = 0;
			try {
				y = Integer.parseInt(labelano.getText());
			}
			catch(Exception e){}
			labelano.setText(String.valueOf(++y));
			updateDayGrid();
		}
		else {
			int m = meses.indexOf(labelmes.getText());
			int y = 0;
			int d = 0;
			try {
				y = Integer.parseInt(labelano.getText());
				d = Integer.parseInt(label);
			}
			catch(Exception e){}
			calendario = new GregorianCalendar(y, m, d);
			calendario.setLenient(false);
		}
	}

	private void updateDayGrid () {
		Paneldia.removeAll();
		
			int m = meses.indexOf(labelmes.getText());
			int y = 0;
			try {
				y = Integer.parseInt(labelano.getText());
			}
			catch(Exception e){}
			GregorianCalendar temp = new GregorianCalendar(y, m, 1);
			temp.setLenient(false);
			int diaSemana = 0;
			switch(temp.get(GregorianCalendar.DAY_OF_WEEK)) {
			case GregorianCalendar.SUNDAY : diaSemana = 0; break;
			case GregorianCalendar.MONDAY : diaSemana = 1; break;
			case GregorianCalendar.TUESDAY : diaSemana = 2; break;
			case GregorianCalendar.WEDNESDAY : diaSemana = 3; break;
			case GregorianCalendar.THURSDAY : diaSemana = 4; break;
			case GregorianCalendar.FRIDAY : diaSemana = 5; break;
			case GregorianCalendar.SATURDAY : diaSemana = 6; break;
			}
			String daynames[]={"Dom","Seg","Ter","Qua","Qui","Sex","Sab"};
			JLabel l[]=new JLabel[7];
			for(int i=0;i<7;i++){
				l[i]=new JLabel(daynames[i], JLabel.CENTER);
				Paneldia.add(l[i]);
				l[0].setForeground(Color.red);
				l[i].setForeground(Color.black);
			}
			for (int i=1; i<=diaSemana; i++) {
				Paneldia.add(new JLabel(""));
			}
			JButton day;
			for (int i=1; i<=getLastDay(); i++) {
				Paneldia.add(day = new JButton(String.valueOf(i)));
				day.addActionListener(this);
				//os outros dias seta como cor azul
				day.setForeground(Color.blue);
				//day.setBackground(getBackground().black);
				Paneldia.setBackground(Color.white);
				//trecho que pega o dia atual e seta na cor vermelha
				if (i == calendario.get(Calendar.DATE) &&
						m == calendario.get(Calendar.MONTH) &&
						y == calendario.get(Calendar.YEAR)) {
					day.setForeground(Color.red);
				}
				for (int i1=0; i1<JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT; i1++) {
					day.addActionListener(new ActionListener() {  
						public void actionPerformed(ActionEvent e) { 
							
						}  
					});  
				}  
			}
			for (int i=(diaSemana+getLastDay()+1); i<=42; i++) {
				Paneldia.add(new JLabel(""));
			}
			repaint();
		}
		private int nextMonth (int month) {
			if (month == 11) {
				return(0);
			}
			return(++month);
		}
		private int prevMonth (int month) {
			if (month == 0) {
				return(11);
			}
			return(--month);
		}
		//função que verfica a quantidade de dias em relação aos meses correspondentes
		private int getLastDay () {
			int m = (meses.indexOf(labelmes.getText()) + 1);
			int y = 0;
			try {
				y = Integer.parseInt(labelano.getText());
			}
			catch(Exception e){}
			if ((m==4) || (m==6) || (m==9) || (m==11)) {
				return(30);
			}
			//verificação do mês de Fevereiro se é de 28 dias ou de 29 dias
			//fazendo consulta com a classe calendar
			else if (m==2) {
				if (calendario.isLeapYear(y)) {
					return(29);
				}
				return(28);
			}
			return(31);
		}
}
