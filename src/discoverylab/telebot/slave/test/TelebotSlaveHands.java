package discoverylab.telebot.slave.test;

import jssc.SerialPort;
import discoverylab.telebot.slave.interfaces.CoreComponent;

public class TelebotSlaveHands extends CoreComponent{

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
	public boolean beginProtocolSequence() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void write() {
		// TODO Auto-generated method stub
		
	}
}
