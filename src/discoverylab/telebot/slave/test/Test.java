package discoverylab.telebot.slave.test;

import static discoverylab.util.LogUtils.*;

import discoverylab.telebot.slave.configurations.Config;

/**
 * 
 * @author 	Irvin Steve Cardenas
 * @twitter	kPatch
 *
 */
public class Test {
	
	public static String TAG = makeLogTag(Test.class);
	
	public static void main(String [] args){
		TelebotSlaveHands telebotSlaveHands = new TelebotSlaveHands(
				Config.SERIAL_PORT_NAME, 
				Config.SERIAL_BAUD_RATE,
				Config.SERIAL_DATA_BITS,
				Config.SERIAL_STOP_BITS,
				Config.SERIAL_PARITY_TYPE,
				Config.SERIAL_EVENT_MASK);
		
		if( telebotSlaveHands.initiate()){
			LOGI(TAG, "Hand Initiation Complete");
		}
		else {
			LOGI(TAG, "Hand Initiation Failed");
		}
		
		if( telebotSlaveHands.calibrate() ){
			LOGI(TAG, "Hand Calibration Complete");
		}
		else {
			LOGI(TAG, "Hand Calibration Failed");
		}
		
		if( telebotSlaveHands.beginProtocolSequence() ) {
			
		}
	}
}
