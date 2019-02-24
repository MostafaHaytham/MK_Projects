#pragma strict
static var count=0;
function Start () {
	transform.animation.Stop();
	transform.audio.Stop();

}

function Update () {


		if(finalpaul.b==1)
		{
			transform.animation.Play("death");
			transform.audio.Play();
			finalpaul.b++;	
			wall.finall=1;
			wall.end=1;
		}

}