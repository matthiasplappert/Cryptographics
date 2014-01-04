package edu.kit.iks.CryptographicsLib;

abstract public class AbstractStepController extends AbstractController {
	abstract public AbstractStepController getNextStep();
	
	abstract public boolean hasNextStep();
}
