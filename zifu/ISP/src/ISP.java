interface IWorker {
	public void DoJob();
}

interface ITakeRest {
	public void TakeRest();	
}

class CHumanWorker implements IWorker, ITakeRest {
	
	
	/*@
	 * requires true
	 *ensures true 
	*/
	
	
	public void DoJob() {
		System.out.println("I am a human, do my job");
	}
	
	/*@
	 * requires true
	 * ensures true 
	 */
	public void TakeRest() {
		System.out.println("I am a human, I need to take rest regularly");
	}
}

class CRobotWorker implements IWorker {
	public void DoJob() {
		System.out.println("I am a robot, do my jod");
	}	
}

interface IFlyable {
	public void fly();
}


interface IRunnable {
	public void run();
}

interface ISwimmable {
	public void swim();
}

class CCat implements IRunnable {
	
	public void run() {
		System.out.println("I am a cat, I can run");
	}
	
}

class CFish implements ISwimmable {
	public void swim() {
		System.out.println("I am a fish, I can swim");
	
}

class CShoe {
	CShoe(String Color) {
		this.Color = Color;
	}
	String Color;
}
interface IHighJumpAble {
	public void Jump();
}
interface ILongJumpAble {
	public void Jump();
}
interface PoleVaulter {
	public void CanPoleVault();
}
interface ITripleJumpAble {
	public void Jump();
}
interface RelayRacer {
	public void CanRelayRace();
}
interface Sprinter {
	public void CanSprint();
}
interface Racer {
	public void CanRace();
}
interface BallPlayer {
	public void CanBallPlay();
}

interface IRider {
	public void CanRide();
}

interface IReferee {
	public void CanRefer();
}

public class ISP {
	public ISP() {
		CShoe pinkDhoe = new CShoe("pink");
	}
	}

}
