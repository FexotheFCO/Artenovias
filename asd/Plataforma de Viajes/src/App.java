import javax.swing.JFrame;

public class App {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		InterfazLogueo login = new InterfazLogueo(frame);
		//InterfazEstadisticas estadisticas = new InterfazEstadisticas();
		//InterfazAdmin admin = new InterfazAdmin(frame);
		//InterfazUsuario user = new InterfazUsuario(frame);
		frame.setContentPane(login);
		frame.setVisible(true);
		frame.setBounds(0, 0, 400, 200);
		}
	}

