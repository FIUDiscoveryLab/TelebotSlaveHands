package discoverylab.telebot.slave.test;

import discoverylab.telebot.slave.configurations.Config;

public class Test {
	
	public static void main(String [] args){
		TelebotSlaveHands telebotSlaveHands = new TelebotSlaveHands(
				Config.SERIAL_PORT_NAME, 
				Config.SERIAL_BAUD_RATE,
				Config.SERIAL_DATA_BITS,
				Config.SERIAL_STOP_BITS,
				Config.SERIAL_PARITY_TYPE,
				Config.SERIAL_EVENT_MASK);
		
		//telebotSlaveHands.initialize();
	}
	
}
