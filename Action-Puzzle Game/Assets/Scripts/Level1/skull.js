#pragma strict
var pick: KeyCode;
var x: int=0;
function Start()
{
	transform.animation.Stop();
	transform.audio.Stop();
}
function OnTriggerEnter2D(Collider2D)
{
	x=1;
	level1.pass = level1.pass+1 ;
	}
function OnTriggerStay2D (col: Collider2D)
	{
		if(Input.GetKey(pick))
			{
				transform.animation.Play("skull");
				transform.audio.Play();
				x=0;
			}
	
	}
function OnGUI ()
{
	if(x==1)
	{
		GUI.Label( new Rect(630,90,200,200),"Pick Up the object with (P)");
	}
}
	



