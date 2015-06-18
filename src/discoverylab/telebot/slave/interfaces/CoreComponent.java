package discoverylab.telebot.slave.interfaces;

import discoverylab.util.*;
import jssc.SerialPort;
import jssc.SerialPortException;

import static discoverylab.util.LogUtils.*;

public abstract class CoreComponent {

	public static String LOG = makeLogTag("CoreComponent");
	private SerialPort serialPort;
	protected Boolean serialConnected = false;
	private Boolean serialPortsAvailable = false;
	
	public CoreComponent(SerialPort serialPort){
		this.serialPort = serialPort;
	}
	
	public CoreComponent(String serialPortName, int baudRate, int dataBits, int stopBits, int parityType, int eveMask){
		serialPort = new SerialPort(serialPortName);
		try {
			serialPort.openPort();
			serialPort.setParams(57600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
			serialPort.setEventsMask(SerialPort.MASK_RXCHAR);
		} catch (SerialPortException e) {
			e.printStackTrace();
		}
	}
}
