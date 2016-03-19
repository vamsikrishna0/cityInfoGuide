/**
 * 
 */
package com.jet.cp.weather.domain;

/**
 * Title: DayWeather.java.java<br>
 * Description: <br>
 * Created: 09-Feb-2016<br>
 * Copyright: Copyright (c) 2015<br>
 * @author Teja Sasank Gorthi (jet.sasank@gmail.com)
 */
public class DayWeather {


	   private String weatherDesc;

	   private float temp;

	   private float tempMin;

	   private float tempMax;

	   private float dayTemp;
	   private float evenTemp;
	   private float nightTemp;
	   private float mornTemp;
	   private float humidity;

	   private String iconUrl;

	   private String clouds;

	   private String snow;
	   private Long date;

	   private String main_desc;
	   /**
	    * @return the weatherDesc as String
	    */
	   public String getWeatherDesc() {
	     return weatherDesc;
	   }

	   /**
	    * @param aWeatherDesc the weatherDesc to set
	    */
	   public void setWeatherDesc(String aWeatherDesc) {
	     weatherDesc = aWeatherDesc;
	   }

	   /**
	    * @return the temp as float
	    */
	   public float getTemp() {
	     return temp;
	   }

	   /**
	    * @param aTemp the temp to set
	    */
	   public void setTemp(float aTemp) {
	     temp = aTemp;
	   }

	   /**
	    * @return the tempMin as float
	    */
	   public float getTempMin() {
	     return tempMin;
	   }

	   /**
	    * @param aTempMin the tempMin to set
	    */
	   public void setTempMin(float aTempMin) {
	     tempMin = aTempMin;
	   }

	   /**
	    * @return the tempMax as float
	    */
	   public float getTempMax() {
	     return tempMax;
	   }

	   /**
	    * @param aTempMax the tempMax to set
	    */
	   public void setTempMax(float aTempMax) {
	     tempMax = aTempMax;
	   }

	   /**
	    * @return the humidity as float
	    */
	   public float getHumidity() {
	     return humidity;
	   }

	   /**
	    * @param aHumidity the humidity to set
	    */
	   public void setHumidity(float aHumidity) {
	     humidity = aHumidity;
	   }

	   /**
	    * @return the iconUrl as String
	    */
	   public String getIconUrl() {
	     return iconUrl;
	   }

	   /**
	    * @param aIconUrl the iconUrl to set
	    */
	   public void setIconUrl(String aIconUrl) {
	     iconUrl = aIconUrl;
	   }

	/**
	 * @return the clouds
	 */
	public String getClouds() {
		return clouds;
	}

	/**
	 * @param clouds the clouds to set
	 */
	public void setClouds(String clouds) {
		this.clouds = clouds;
	}

	/**
	 * @return the snow
	 */
	public String getSnow() {
		return snow;
	}

	/**
	 * @param snow the snow to set
	 */
	public void setSnow(String snow) {
		this.snow = snow;
	}

/**
 * @return the date
 */
public Long getDate() {
	return date;
}

/**
 * @param date the date to set
 */
public void setDate(Long date) {
	this.date = date;
}

/**
 * @return the main_desc
 */
public String getMain_desc() {
	return main_desc;
}

/**
 * @param main_desc the main_desc to set
 */
public void setMain_desc(String main_desc) {
	this.main_desc = main_desc;
}

/**
 * @return the dayTemp
 */
public float getDayTemp() {
	return dayTemp;
}

/**
 * @param dayTemp the dayTemp to set
 */
public void setDayTemp(float dayTemp) {
	this.dayTemp = dayTemp;
}

/**
 * @return the evenTemp
 */
public float getEvenTemp() {
	return evenTemp;
}

/**
 * @param evenTemp the evenTemp to set
 */
public void setEvenTemp(float evenTemp) {
	this.evenTemp = evenTemp;
}

/**
 * @return the nightTemp
 */
public float getNightTemp() {
	return nightTemp;
}

/**
 * @param nightTemp the nightTemp to set
 */
public void setNightTemp(float nightTemp) {
	this.nightTemp = nightTemp;
}

/**
 * @return the mornTemp
 */
public float getMornTemp() {
	return mornTemp;
}

/**
 * @param mornTemp the mornTemp to set
 */
public void setMornTemp(float mornTemp) {
	this.mornTemp = mornTemp;
}

}
