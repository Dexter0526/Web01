package com.company.project.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.project.dto.g2bSearchDto;
import com.company.project.dto.g2bSearchRequestDto;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
@Transactional
public class XmlPareServiceImpl implements ParseService{

//	private RestTemplate template = new RestTemplate();
	private final String URL = "http://apis.data.go.kr/1230000/ScsbidInfoService/getOpengResultListInfoCnstwk";
//	private final String key = "9s4gRft8gnWr6fo6gnxD6UXBzHj5gLGjGfllSuazFkendirH%2FyPbiZ7uirB2ZzwaWcC87qQChsI5w2t20BSnwA%3D%3D";

	
//	public static void main(String[] args) {
//				
//		BufferedReader reader = null;
//		try {
//			URL url = new URL("http://apis.data.go.kr/1230000/ScsbidInfoService/getOpengResultListInfoCnstwk?serviceKey=9s4gRft8gnWr6fo6gnxD6UXBzHj5gLGjGfllSuazFkendirH%2FyPbiZ7uirB2ZzwaWcC87qQChsI5w2t20BSnwA%3D%3D&numOfRows=10&pageNo=1&inqryDiv=1&inqryBgnDt=201605010000&inqryEndDt=201605052359&bidNtceNo=20160329825&type=json");
//			
//			reader = new BufferedReader(new InputStreamReader(url.openStream(), "utf-8"));
//			
//			String line = "";
//			while ((line = reader.readLine()) != null) {
//				System.out.println(line);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}
	
	@Override
	public List<g2bSearchDto> parseNara(g2bSearchRequestDto dto){
		List<g2bSearchDto> nara = new ArrayList<g2bSearchDto>();
		BufferedReader reader = null;
		
//		dto.setNumOfRows(dto.getNumOfRows() != null ? "&numOfRows="+dto.getNumOfRows() : "");
//		dto.setPageNo(dto.getPageNo() != null ? "&pageNo="+dto.getPageNo() : "");
//		dto.setInqryDiv(dto.getInqryDiv() != null ? "&inqryDiv=" + dto.getInqryDiv() : "");
//		dto.setInqryBgnDt(dto.getInqryBgnDt() != null ? "&inqryBgnDt="+dto.getInqryBgnDt() : "");
//		dto.setInqryEndDt(dto.getInqryEndDt() != null ? "&inqryEndDt="+dto.getInqryEndDt() : "");
//		dto.setBidNtceNo(dto.getBidNtceNo() != null ? "&bidNtceNo="+dto.getBidNtceNo() : "");
		
		try {
//			URL url = new URL("http://apis.data.go.kr/1230000/ScsbidInfoService/getOpengResultListInfoCnstwk?serviceKey=9s4gRft8gnWr6fo6gnxD6UXBzHj5gLGjGfllSuazFkendirH%2FyPbiZ7uirB2ZzwaWcC87qQChsI5w2t20BSnwA%3D%3D&numOfRows=10&pageNo=1&inqryDiv=1&inqryBgnDt=201605010000&inqryEndDt=201705052359&bidNtceNo=20160329825&type=json");
			URL url = new URL(URL 
					+ dto.getServiceKey() 
					+ (dto.getPageNo() != null ? "&pageNo="+dto.getPageNo() : "")
					+ (dto.getNumOfRows() != null ? "&numOfRows="+dto.getNumOfRows() : "")
					+ (dto.getInqryDiv() != null ? "&inqryDiv=" + dto.getInqryDiv() : "")
					+ (dto.getInqryBgnDt() != null ? "&inqryBgnDt="+dto.getInqryBgnDt() : "")
					+(dto.getInqryEndDt() != null ? "&inqryEndDt="+dto.getInqryEndDt() : "")
					+ (dto.getBidNtceNo() != null ? "&bidNtceNo="+dto.getBidNtceNo() : "")
					+ "&type=json");
			
			log.info("url : " + url);
		
			reader = new BufferedReader(new InputStreamReader(url.openStream(), "utf-8"));

			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
			JSONObject response = (JSONObject) jsonObject.get("response");
			JSONObject body = (JSONObject) response.get("body");
			JSONArray naraListArray = (JSONArray) body.get("items");
			
			Iterator<JSONObject> iter = naraListArray.iterator();
			
			while(iter.hasNext()) {
				JSONObject rowObject = (JSONObject) iter.next();
				
				g2bSearchDto g2bDto = new g2bSearchDto();
				g2bDto.setBidNtceNo((String) rowObject.get("bidNtceNo"));
				g2bDto.setBidNtceOrd((String) rowObject.get("bidNtceOrd"));
				g2bDto.setBidClsfcNo((String) rowObject.get("bidClsfcNo"));
				g2bDto.setRbidNo((String) rowObject.get("rbidNo"));
				g2bDto.setBidNtceNm((String) rowObject.get("bidNtceNm"));
				g2bDto.setOpengDt((String) rowObject.get("opengDt"));
				g2bDto.setPrtcptCnum((String) rowObject.get("prtcptCnum"));
				g2bDto.setOpengCorpInfo((String) rowObject.get("opengCorpInfo"));
				g2bDto.setProgrsDivCdNm((String) rowObject.get("progrsDivCdNm"));
				g2bDto.setInptDt((String) rowObject.get("inptDt"));
				g2bDto.setRsrvtnPrceFileExistnceYn((String) rowObject.get("rsrvtnPrceFileExistnceYn"));
				g2bDto.setNtceInsttCd((String) rowObject.get("ntceInsttCd"));
				g2bDto.setNtceInsttNm((String) rowObject.get("ntceInsttNm"));
				g2bDto.setDminsttCd((String) rowObject.get("dminsttCd"));
				g2bDto.setDminsttNm((String) rowObject.get("dminsttNm"));
				
				nara.add(g2bDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return nara;
	}
}
