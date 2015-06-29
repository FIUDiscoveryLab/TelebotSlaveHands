package discoverylab.telebot.slave.hands.test;

import static discoverylab.util.LogUtils.*;

import com.rti.dds.subscription.Subscriber;

import TelebotDDSCore.Source.Java.Generated.master.hands.TMasterToHands;
import TelebotDDSCore.Source.Java.Generated.master.hands.TMasterToHandsDataReader;
import TelebotDDSCore.Source.Java.Generated.master.hands.TOPIC_MASTER_TO_SLAVE_HANDS;
import discoverylab.telebot.slave.configurations.Config;
import discoverylab.telebot.slave.hands.configurations.SlaveHandsConfig;
import discoverylab.telebot.slave.hands.listeners.TMasterToHandsListener;
import discoverylab.telebot.slave.hands.listeners.TSlaveHandsListener;
/**
 * 
 * @author 	Irvin Steve Cardenas
 * @twitter	kPatch
 *
 */
public class TelebotSlaveHandsTest {
	
	public static String TAG = makeLogTag(TelebotSlaveHandsTest.class);
	
	public static void main(String [] args){
		
		TelebotSlaveHands telebotSlaveHands = new TelebotSlaveHands(
				  SlaveHandsConfig.DEFAULT_SERIAL_PORT_NAME
				, SlaveHandsConfig.DEFAULT_SERIAL_BAUD_RATE
				, SlaveHandsConfig.DEFAULT_SERIAL_DATA_BITS
				, SlaveHandsConfig.DEFAULT_SERIAL_STOP_BITS
				, SlaveHandsConfig.DEFAULT_SERIAL_PARITY_TYPE
				, SlaveHandsConfig.DEFAULT_SERIAL_EVENT_MASK);
		
// 1. INITIATE Slave Component DEVICE
		if( telebotSlaveHands.initiate()){
			LOGI(TAG, "Hand Initiation Complete");
		}
		else {
			LOGI(TAG, "Hand Initiation Failed");
		}
		
// 2. CALIBRATE
		if( telebotSlaveHands.calibrate() ){
			LOGI(TAG, "Hand Calibration Complete");
		}
		else {
			LOGI(TAG, "Hand Calibration Failed");
		}
		
// 3. INITIATE Transmission PROTOCOL
		TSlaveHandsListener listener = new TSlaveHandsListener();
		
		if( telebotSlaveHands.initiateTransmissionProtocol(
				  TOPIC_MASTER_TO_SLAVE_HANDS.VALUE
				, TMasterToHands.class, listener) ) {
			LOGI(TAG, "Protocol Sequence Initiated");
		}
		else {
			LOGI(TAG, "Protocol Sequence Failed");
		}
		
// 4. INITIATE Transmission SEQUENCE		
		LOGI(TAG, "Iniating Transmission Sequence");
	}
}
