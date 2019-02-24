

#pragma strict
var x: int=0;
var pick: KeyCode;


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
function OnTriggerStay2D (coll: Collider2D)
	{
			if(Input.GetKey(pick))
			{
				transform.animation.Play("paper");;
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
