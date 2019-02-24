#pragma strict
static var finall:int=0;
static var end:int=0;
function Start () {
	transform.animation.Stop();

}

function Update () {


		if(finalpaul.bcount==3)
		{
			transform.animation.Play("wallanim");
			finalpaul.bcount=4;
			finalpaul.b=1;	
		}

}