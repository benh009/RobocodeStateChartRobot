import org.apache.commons.scxml2.model.ModelException;

import com.hofbauer.robocode.simulateur.RobotStateMachine;


public class SimulateurALaMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RobotStateMachine robotModel=null;
		try {
			 robotModel = new RobotStateMachine("/com/hofbauer/robocode/resources/simulation/scxml/testAlaMain.scxml");
		} catch (ModelException e) {
			System.out.println("Error init robotStateMachine");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		robotModel.getEngine().getRootContext().set("Double1", new Double(2));
		//robotModel.getEngine().getRootContext().set("Ob", new ObjectTestNewSCXML() );

		robotModel.fireEvent("event");
Double x = new Double(3);


	}

}
