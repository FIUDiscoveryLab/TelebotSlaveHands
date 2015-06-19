package discoverylab.telebot.slave.test;

import com.rti.dds.topic.Topic;

import jssc.SerialPort;
import discoverylab.telebot.slave.interfaces.CoreSlaveComponent;

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

	@Override
	public void write() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTopic(Topic topic) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setReader() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setListener() {
		// TODO Auto-generated method stub
		
	}
}
