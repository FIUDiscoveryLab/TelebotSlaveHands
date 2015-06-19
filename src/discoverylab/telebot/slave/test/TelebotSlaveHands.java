package discoverylab.telebot.slave.test;

import com.rti.dds.topic.Topic;

import jssc.SerialPort;
import discoverylab.telebot.slave.core.CoreSlaveComponent;

/**
 * 
 * @author Irvin Steve Cardenas
 *
 */
public class TelebotSlaveHands extends CoreSlaveComponent{

	public TelebotSlaveHands(SerialPort serialPort){
		super(serialPort);
	}
	
	public TelebotSlaveHands(String serialPortName, int baudRate, int dataBits,
			int stopBits, int parityType, int eveMask) {
		super(serialPortName, baudRate, dataBits, stopBits, parityType, eveMask);
	}
	
	@Override
	public boolean calibrate() {
		// TODO Auto-generated method stub
		return true;
	}
}
