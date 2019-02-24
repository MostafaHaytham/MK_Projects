#pragma strict

function Start () {

}

function Update () {

	if(finalpaul.bcount>3)
	{
		transform.animation.Stop();
		}
		else
		{	
		transform.animation.Play();
		}

}

function OnTriggerEnter2D (col: Collider2D)
{
		if(finalpaul.bcount<3  )
		{
			if(finalpaul.bcount>=3)
			{
				Debug.Log(finalpaul.bcount);
			}
			else
			{
				finalpaul.bcount++;
				}
				
			
		}
	
}