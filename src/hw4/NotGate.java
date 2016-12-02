package hw4;

import api.Endpoint;
import api.IComponent;

public class NotGate implements IComponent {

	/**
	   * Outputs for this component.
	   */
	  private Endpoint[] outputs;
	  
	  /**
	   * Inputs for this component.
	   */
	  private Endpoint[] inputs;
	  
	  /**
	   * Constructs an not-gate.
	   */
	  public NotGate()
	  {
	    inputs = new Endpoint[1];
	    inputs[0] = new Endpoint(this);
	    outputs = new Endpoint[1];
	    outputs[0] = new Endpoint(this);
	  }
	  
	  /**
	   * Changes the state of all inputs to invalid.
	   */
	  @Override
	  public void invalidateInputs()
	  {
	    for (Endpoint e : inputs) e.invalidate();
	  }
	  
	  /**
	   * Changes the state of all outputs to invalid.
	   */
	  @Override
	  public void invalidateOutputs()
	  {
	    for (Endpoint e : outputs) e.invalidate();
	  }
	  
	  /**
	   * Returns whether all inputs are valid.
	   * @return
	   *   true if all inputs are valid, false otherwise
	   */
	  @Override
	  public boolean inputsValid()
	  {
	    for (Endpoint e : inputs)
	    {
	      if (!e.isValid()) return false;
	    }
	    return true;
	  }
	  
	  /**
	   * Returns whether all outputs are valid.
	   * @return
	   *   true if all outputs are valid, false otherwise
	   */ 
	  @Override
	  public boolean outputsValid()
	  {
	    for (Endpoint e : outputs)
	    {
	      if (!e.isValid()) return false;
	    }
	    return true;
	  }
	  
	  /**
	   * Returns the array of Endpoints representing this component's inputs.
	   * @return
	   *   array of input Endpoints
	   */
	  @Override
	  public Endpoint[] inputs()
	  {
	    return inputs;
	  }

	  /**
	   * Returns the array of Endpoints representing this component's outputs.
	   * @return
	   *   array of output Endpoints
	   */
	  @Override
	  public Endpoint[] outputs()
	  {
	    return outputs;
	  }
	  
	  /**
	   * Propagates inputs to outputs.  Does nothing if not all inputs are valid.
	   */
	  @Override
	  public void propagate()
	  {
	    if (inputsValid())
	    {
	      int newValue = 0;
	      if (inputs()[0].getValue() == 0)
	      {
	        newValue = 1;
	      }
	      outputs()[0].set(newValue);
	    }
	  }
}
