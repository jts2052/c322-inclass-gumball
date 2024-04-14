package edu.iu.habahram.GumballMachine.model;

public class HasQuarterState implements IState {
    IGumballMachine gumballMachine;

    public HasQuarterState(IGumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public TransitionResult insertQuarter() {
        gumballMachine.changeTheStateTo(GumballMachineState.HAS_QUARTER);
        String message = "There is already a quarter in the machine";
        boolean succeeded = false;
        int count = gumballMachine.getCount();
        return new TransitionResult(succeeded, message, gumballMachine.getTheStateName(), count);
    }

    @Override
    public TransitionResult ejectQuarter() {
        String message = "Quarter returned";
        boolean succeeded = true;
        return new TransitionResult(succeeded, message, gumballMachine.getTheStateName(), gumballMachine.getCount());
    }

    @Override
    public TransitionResult turnCrank() {
        String message = "You turned the crank";
        boolean succeeded = true;
        return new TransitionResult(succeeded, message, gumballMachine.getTheStateName(), gumballMachine.getCount());
    }

    @Override
    public TransitionResult dispense() {
        String message = "Gumball dispensed";
        boolean succeeded = true;
        return new TransitionResult(succeeded, message, gumballMachine.getTheStateName(), gumballMachine.getCount());
    }

    @Override
    public String getTheName() {
        return GumballMachineState.HAS_QUARTER.name();
    }
}
