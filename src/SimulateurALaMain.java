import org.apache.commons.scxml2.model.ModelException;

import com.hofbauer.robocode.simulateur.RobotStateMachine;


public class SimulateurALaMain {

	/**
	 * cette classe permet de tester a la main si un modèle réagis bien 
	 * aux évènements comme on le souhaite
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		RobotStateMachine robotModel=null;
		try {
			 robotModel = new RobotStateMachine(SimulateurALaMain.class.getResource("/com/hofbauer/robocode/resources/simulation/scxml/testSup1.scxml"));
		} catch (ModelException e) {
			System.out.println("Error init robotStateMachine");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//robotModel.getEngine().getRootContext().set("Double1", new Double(2));
		//robotModel.getEngine().getRootContext().set("Ob", new ObjectTestNewSCXML() );
		robotModel.fireEvent("b");
		robotModel.fireEvent("a");
		System.out.println("etat "+robotModel.getEngine().getCurrentStatus().getStates());
		

	}

}
