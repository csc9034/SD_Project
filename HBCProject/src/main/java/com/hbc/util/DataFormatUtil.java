package com.hbc.util;

/**
 * DB에 저장된 또는 저장될
 * 데이터들을 태그 또는 원상태로 바꾸거나
 * 하이픈 처리된 번호 등을 변환하는
 * 유틸 클래스
 * 
 * @author 진재환
 *
 */
public class DataFormatUtil
{
	/**
	 * DB에 저장된 게시물 내용의 띄어쓰기나
	 * 줄바꿈을 &nbsp;, <br/>로 바꾸는 메소드
	 */
	public static String contentModelToView(String content)
	{		
		String outputContent = content;
		// 게시물 내용이 null이 아니고 공백이 아니면
		if (outputContent != null && !outputContent.equals(""))
		{
			// 내용이 <br/>을 포함하고 있지 않으면 메소드 종료
			if (!outputContent.contains("<br/>")) return outputContent;
			
			// 인덱스 변수 선언
			int idx = 0;
			
			// 내용이 <br/>를 포함할 동안에 반복
			while (outputContent.contains("<br/>"))
			{
				// 인덱스의 문자가 <br/>일 때
				if ((outputContent.charAt(idx) == '<')
					&& (outputContent.charAt(idx + 1) == 'b')
					&& (outputContent.charAt(idx + 2) == 'r')
					&& (outputContent.charAt(idx + 3) == '/')
					&& (outputContent.charAt(idx + 4) == '>'))
				{
					// <br/>의 앞쪽 문자열을 저장함
					String front = outputContent.substring(0, idx);
					// <br/>의 뒷쪽 문자열을 저장함
					String rear = outputContent.substring(idx + 5, outputContent.length());
					// \n을 중간에 끼워놓음
					outputContent = front + "\n" + rear;
				}
				
				// 인덱스 증가
				idx++;
			}
		}
		
		return outputContent;
	}
	
	/**
	 * DB에 저장된 게시물 내용의 &nbsp;나
	 * <br/>을 띄어쓰기, 줄바꿈으로 바꾸는 메소드
	 */
	public static String contentViewToModel(String content)
	{
		String outputContent = content;
		// 게시물 내용이 null이 아니고 공백이 아니면
		if (outputContent != null && !outputContent.equals(""))
		{
			// 내용이 \n을 포함하고 있지 않으면 메소드 종료
			if (!outputContent.contains("\n")) return outputContent;

			// 인덱스 변수 선언
			int idx = 0;
			
			// 내용이 \n를 포함할 동안에 반복
			while (outputContent.contains("\n"))
			{
				// 인덱스의 문자가 줄바꿈 문자일 때
				if (outputContent.charAt(idx) == '\n')
				{
					// \n의 앞쪽 문자열을 저장함
					String front = outputContent.substring(0, idx);
					// \n의 뒷쪽 문자열을 저장함
					String rear = outputContent.substring(idx + 1, outputContent.length());
					// <br/>을 중간이 끼워놓음
					outputContent = front + "<br/>" + rear;
				}
				
				// 인덱스 증가
				idx++;
			}
		}
		
		return outputContent;
	}
	
	/**
	 * 전화번호의 하이픈을 제거하는 메소드
	 * @param phone
	 * @return 하이픈이 없어진 전화번호
	 * 
	 * 2018/08/24 강현 : 컨트롤러 단에서 하이픈 제거해주는 구문사용하기 때문에 
	 *                   더이상 이 메소드를 사용하지 않음
	 */
	@Deprecated
	public static String phoneViewToModel(String phone) throws Exception
	{
		String output = phone;
		
		if (output != null && !output.equals(""))
		{
			// 내용이 -을 포함하고 있지 않으면 메소드 종료
			if (!output.contains("-")) return output;

			// 인덱스 변수 선언
			int idx = 0;
			
			// 내용이 -를 포함할 동안에 반복
			while (output.contains("-"))
			{
				// 인덱스의 문자가 - 문자일 때
				if (output.charAt(idx) == '-')
				{
					// -의 앞쪽 문자열을 저장함
					String front = output.substring(0, idx);
					// -의 뒷쪽 문자열을 저장함
					String rear = output.substring(idx + 1, output.length());
					// 프론트와 엔드를 합침
					output = front + rear;
				}
				
				// 인덱스 증가
				idx++;
			}
		}
		
		return output;
	}
	
	/**
	 * 뷰에 보여질 전화번호에
	 * 하이픈을 적절하게 추가하는 메소드
	 * @param phone
	 * @return 하이픈이 들어간 전화번호
	 */
	public static String phoneModelToView(String phone)
	{
		String temp = "";
		
		if (phone.length() < 4) {
	        return phone;
	    } else if (phone.length() < 7) {
	        temp += phone.substring(0, 3);
	        temp += '-';
	        temp += phone.substring(3);
	        return temp;
	    } else if (phone.length() < 11) {
	        temp += phone.substring(0, 3);
	        temp += '-';
	        temp += phone.substring(3, 6);
	        temp += '-';
	        temp += phone.substring(6);
	        return temp;
	    } else {
	        temp += phone.substring(0, 3);
	        temp += '-';
	        temp += phone.substring(3, 7);
	        temp += '-';
	        temp += phone.substring(7);
	        return temp;
	    }
	}
}
