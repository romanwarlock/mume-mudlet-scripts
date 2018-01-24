//usage: #scri timedk()
//can do #alias {timedk} {#scri timedk()} 
//t0 corresponed to moonrise at 7pm, 3rd night when is unlcoks
//t0 must be set manually from time to time
function seconds_to_hms(time_as_seconds, zero){
	if (zero == null) {
		zero = "now";
	}
	var hours = Math.floor(time_as_seconds / 3600);
	var time_wo_hours = time_as_seconds - hours * 3600;
	var minutes = Math.floor(time_wo_hours / 60);
	var seconds = time_wo_hours - minutes * 60;
	var result = "";
	if (hours != 0) {result = result + hours + "h";}
	if (minutes != 0) {result = result + minutes + "m";}
	if (seconds != 0) {result = result +""+ seconds + "s";}
	if (result == "") {result = zero;}
	return result;
}

function stamp_hm(timestamp){
         var datn = new Date(timestamp*1000);
         var hourn = datn.getHours();
         var minuten = datn.getMinutes();
         if (minuten<10) {var formattedTime = hourn + ":0" + minuten;}
         else {var formattedTime = hourn + ":" + minuten;}
return formattedTime;
}

function timedk(){
  var t0 = new Date("Jun 2, 2017 12:19:21").getTime()/1000;
  var tc = new Date().getTime()/1000;
  var p = 34560;
  var tn=  Math.floor(t0+p*(Math.floor((tc-t0)/p)+1));
  var OpensAt = stamp_hm(tn);
  if (tn-1500>=tc){
    tn = tn-1500;
    OpensAt = stamp_hm(tn)+" "+OpensAt;
    if (tn - 1500>=tc){
      tn = tn-1500;
      OpensAt = stamp_hm(tn)+" "+OpensAt;
     }
  }
  OpensIn=Math.floor(tn-tc);
  jmc.showme("DK unlocks in "+ seconds_to_hms(OpensIn)+" at "+OpensAt, "light green");
}
