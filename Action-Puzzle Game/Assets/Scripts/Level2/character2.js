#pragma strict

var ch2: KeyCode;
var count:int=0;

function Start () {

 transform.animation.Stop();
}

function Update () {

	 if(Input.GetKey(ch2) && C1.money>=50 && C1.count<2 &&count==0)
	{
	
		transform.animation.Play("char2anim");
		C1.money =C1.money-50;
		C1.count =C1.count+1;
		count=count+1;
		bg.ch2=1;
		Debug.Log(bg.ch2);
	}

}