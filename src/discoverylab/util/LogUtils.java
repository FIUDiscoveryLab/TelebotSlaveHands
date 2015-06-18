package discoverylab.util;
import java.util.logging.Logger;

public class LogUtils {
	
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	
	private static final String LOG_PREFIX = "discoverylab";
	private static final int LOG_PREFIX_LENGTH = LOG_PREFIX.length();
	private static final int MAX_LOG_TAG_LENGTH = 23;
	
	public static String makeLogTag(String str) {
		if(str.length() > MAX_LOG_TAG_LENGTH - LOG_PREFIX_LENGTH){
			return LOG_PREFIX + str.substring(0, MAX_LOG_TAG_LENGTH - LOG_PREFIX_LENGTH);
		}
		return LOG_PREFIX + str;
	}
	
	public static String makeLogTag(Class cls) {
		return makeLogTag(cls.getSimpleName());
	}
	
	public static void LOGE(final String tag, String message){
	}
}
