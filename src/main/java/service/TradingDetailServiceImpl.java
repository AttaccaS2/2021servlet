package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import mapper.TradingDetailMapper;
import model.TradingDetailVO;

public class TradingDetailServiceImpl implements TradingDetailService{

	private TradingDetailMapper mapper;
	
	public TradingDetailServiceImpl() {
		this.mapper = new TradingDetailMapper();
	}
		
	@Override
	public void create(TradingDetailVO vo) {
		mapper.create(vo);
		
	}

	@Override
	public List<TradingDetailVO> read(int tra_num) {		
		return mapper.read(tra_num);
	}

	@Override
	public void modify(HttpServletRequest request) {
		
		int tra_num = Integer.parseInt(request.getParameter("tra_num"));
		mapper.delete(tra_num);
			
		//지우고 다시 등록		
		for(int i=0 ; i<request.getParameterValues("tradingDate").length; i++) {
			String tradingDateStr = request.getParameterValues("tradingDate")[i];
			String subject = request.getParameterValues("subject")[i];
			String standard = request.getParameterValues("standard")[i];
			String quantity = request.getParameterValues("quantity")[i];
			String unitPrice = request.getParameterValues("unitPrice")[i];
			String supplyPrice = request.getParameterValues("supplyPrice")[i];
			String taxAmount = request.getParameterValues("taxAmount")[i];
			String note = request.getParameterValues("note")[i];
			
			//값없으면 중단
			if(tradingDateStr==null || "".equals(tradingDateStr)) {	
				break;
			} 
			
			//넘어온 값이 string 이라서 java.utill.date로 만들어줘야
			Date tradingDate = null;
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			try {
				tradingDate = format.parse(tradingDateStr);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//값이 있을 경우 계속			
			TradingDetailVO tradingDetail = new TradingDetailVO();
			tradingDetail.setTrad_refnum(tra_num); //refnum 이 tra_num 값 참조하는 외래키
			tradingDetail.setTrad_traingDate(tradingDate);
			tradingDetail.setTrad_subject(subject);
			tradingDetail.setTrad_standard(standard);
			tradingDetail.setTrad_quantity(Integer.parseInt(quantity));
			tradingDetail.setTrad_unitPrice(Integer.parseInt(unitPrice));
			tradingDetail.setTrad_supplyPrice(Integer.parseInt(supplyPrice));
			tradingDetail.setTrad_taxAmount(Integer.parseInt(taxAmount));
			tradingDetail.setTrad_note(note);
			
			//db에 저장하러 가자
			mapper.create(tradingDetail); //서비스 가서 매퍼로 연결 
			
			System.out.println(tradingDetail);
		}//for 반복문 끝
	}

}
