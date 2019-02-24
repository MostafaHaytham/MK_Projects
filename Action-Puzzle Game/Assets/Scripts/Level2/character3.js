#pragma strict

var ch3: KeyCode;
var count:int=0;
function Start () {

 transform.animation.Stop();
}

function Update () {

	 if(Input.GetKey(ch3) && C1.money>=50 && C1.count<2 && count==0)
	{
	
		transform.animation.Play("char3anim");
		C1.money =C1.money-50;
		C1.count =C1.count+1;
		count=count+1;
		bg.ch3=1;
		Debug.Log(bg.ch3);
	}

}
 
 