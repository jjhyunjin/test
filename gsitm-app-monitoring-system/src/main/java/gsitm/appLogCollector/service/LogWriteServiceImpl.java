package gsitm.appLogCollector.service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;

import gsitm.appLogCollector.CommonConstants;
import gsitm.appLogCollector.util.DateUtil;

@Service
public class LogWriteServiceImpl implements LogWriteService {
	
	public void logWrite(Object data) {
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			String jsonResult = "";
			String fileName = DateUtil.getcurrentDate();
			jsonResult = mapper.writeValueAsString(data);
			
			PrintWriter pw = new PrintWriter(new FileWriter(CommonConstants.LOG_PATH + fileName + ".txt", true));
			pw.write(jsonResult);
			pw.write("\n");
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}




