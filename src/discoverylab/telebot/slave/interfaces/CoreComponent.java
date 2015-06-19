package discoverylab.telebot.slave.interfaces;

import discoverylab.util.*;
import jssc.SerialPort;
import jssc.SerialPortException;
import static discoverylab.util.LogUtils.*;

public abstract class CoreComponent {

	public static String TAG = makeLogTag("CoreComponent");
	private SerialPort serialPort;
	protected Boolean serialConnected = false;
	private Boolean serialPortsAvailable = false;
	
	private String serialPortName;
	private int baudRate;
	private int dataBits;
	private int stopBits; 
	private int parityType;
	private int eventMask;
	
	/**
	 * Default Constructor Uses Default Values For Serial Connection
	 * @param serialPort 
	 */
	public CoreComponent(SerialPort serialPort){
		this.serialPort = serialPort;
		
		this.baudRate 			= CoreHandsConfig.DEFAULT_SERIAL_BAUD_RATE;
		this.dataBits 			= CoreHandsConfig.DEFAULT_SERIAL_DATA_BITS;
		this.stopBits 			= CoreHandsConfig.DEFAULT_SERIAL_STOP_BITS;
		this.parityType 		= CoreHandsConfig.DEFAULT_SERIAL_PARITY_TYPE;
		this.eventMask 			= CoreHandsConfig.DEFAULT_SERIAL_EVENT_MASK;
	}
	
	/**
	 * 
	 * @param serialPortName
	 * @param baudRate
	 * @param dataBits
	 * @param stopBits
	 * @param parityType
	 * @param eventMask
	 */
	public CoreComponent(String serialPortName, int baudRate, int dataBits, int stopBits, int parityType, int eventMask){
		this.serialPortName 	= serialPortName;
		this.baudRate 			= baudRate;
		this.dataBits 			= dataBits;
		this.stopBits 			= stopBits;
		this.parityType 		= parityType;
		this.eventMask 			= eventMask;
		
		serialPort = new SerialPort(serialPortName);
	}
	
	/**
	 * Slave Hands Initiate - Open Hand Serial Connection
	 * @return
	 */
	@SuppressWarnings("finally")
	public boolean initiate(){
		try {
			serialPort.openPort();
			serialPort.setParams(57600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
			serialPort.setEventsMask(SerialPort.MASK_RXCHAR);
		} catch (SerialPortException e) {
			LOGE(TAG, "Error opening SerialPort: " + serialPortName  + " with Baudrate: " + baudRate);
			e.printStackTrace();
		}
		finally{
			return serialPort.isOpened();
		}
	}
	
	public abstract boolean calibrate();
	public abstract boolean beginProtocolSequence();
	public abstract void write();

}
