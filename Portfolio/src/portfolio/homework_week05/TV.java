package portfolio.homework_week05;

public class TV {
	public boolean power=true;
	public int channel = 7;
	public int volume = 2;
	
	public void powerOnOff() {
		power = !power;
		showTV();
	}
	
	public void channelUp() {
		if(power)
			++channel;
		showTV();
	}
	
	public void channelDown() {
		if(power)
			--channel;
		showTV();
	}
	
	public void volumeUp() {
		if(power) {
			if(volume == 20)
				volume = 20;
			else
				++volume;
		}
		showTV();
	}
	
	public void volumeDown() {
		if(power) {
			if(volume == 0) 
				volume = 0;
			else
				--volume;
		}
		showTV();
	}
	
	public void changeChannel(int ch) {
		if(power)
			channel = ch;
		showTV();
	}
	
	public void changeVolume(int vol) {
		if(power) {
			if(vol < 0) 
				volume = 0;
			else if (vol > 20)
				volume = 20;
			else
				volume = vol;
		}
		showTV();
	}
	
	public void showTV() {
		if(power)
			System.out.println("채널 : " + channel + "번 시청중 음량 : " + volume );
		else
			System.out.println("전원이 꺼져있습니다.");
	}

}
