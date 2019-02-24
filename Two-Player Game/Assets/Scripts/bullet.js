#pragma strict
var anim:Animator;
var c1:KeyCode;
var c2:KeyCode;
var c3:KeyCode;
var c4:KeyCode;
var shot:KeyCode;
var turn:KeyCode;
function Start () {
		anim = GetComponent("Animator");
		anim.SetBool ("bmain", true);
		transform.GetComponent.<AudioSource>().Stop();
}

function Update () {
if (Input.GetKey (c1) && mainscript.playercount==0 && mainscript.player==1  && mainscript.destroyedships2[0]==0  ) {
			anim.SetBool ("bship11", true);
			anim.SetBool ("bship12", false);
			anim.SetBool ("bship13", false);
			anim.SetBool ("bship14", false);
			anim.SetBool ("bship24", false);
			anim.SetBool ("bship22", false);
			anim.SetBool ("bship23", false);
			anim.SetBool ("bship21", false);
			anim.SetBool ("bmain", false);
				}
		else if (Input.GetKey (c2) && mainscript.playercount==0 && mainscript.player==1 && mainscript.destroyedships2[1]==0 ) {
			anim.SetBool ("bship12", true);
			anim.SetBool ("bship11", false);
			anim.SetBool ("bship13", false);
			anim.SetBool ("bship14", false);
			anim.SetBool ("bship24", false);
			anim.SetBool ("bship22", false);
			anim.SetBool ("bship23", false);
			anim.SetBool ("bship21", false);
			anim.SetBool ("bmain", false);
		}
		else if (Input.GetKey (c3)&& mainscript.playercount==0 && mainscript.player==1 && mainscript.destroyedships2[2]==0 ) {
			anim.SetBool ("bship13", true);
			anim.SetBool ("bship12", false);
			anim.SetBool ("bship11", false);
			anim.SetBool ("bship14", false);
			anim.SetBool ("bship24", false);
			anim.SetBool ("bship22", false);
			anim.SetBool ("bship23", false);
			anim.SetBool ("bship21", false);
			anim.SetBool ("bmain", false);
		}
		else if (Input.GetKey (c4)&& mainscript.playercount==0 && mainscript.player==1 && mainscript.destroyedships2[3]==0 ) {
			anim.SetBool ("bship14", true);
			anim.SetBool ("bship12", false);
			anim.SetBool ("bship13", false);
			anim.SetBool ("bship11", false);
			anim.SetBool ("bship24", false);
			anim.SetBool ("bship22", false);
			anim.SetBool ("bship23", false);
			anim.SetBool ("bship21", false);
			anim.SetBool ("bmain", false);
		}
		else if (Input.GetKey (c1) && mainscript.playercount==0 && mainscript.player==2 && mainscript.destroyedships[0]==0 ) {
			anim.SetBool ("bship21", true);
			anim.SetBool ("bship22", false);
			anim.SetBool ("bship23", false);
			anim.SetBool ("bship24", false);
			anim.SetBool ("bship14", false);
			anim.SetBool ("bship12", false);
			anim.SetBool ("bship13", false);
			anim.SetBool ("bship11", false);
			anim.SetBool ("bmain", false);
				}
		else if (Input.GetKey (c2) && mainscript.playercount==0 && mainscript.player==2 && mainscript.destroyedships[1]==0) {
			anim.SetBool ("bship22", true);
			anim.SetBool ("bship21", false);
			anim.SetBool ("bship23", false);
			anim.SetBool ("bship24", false);
			anim.SetBool ("bship14", false);
			anim.SetBool ("bship12", false);
			anim.SetBool ("bship13", false);
			anim.SetBool ("bship11", false);
			anim.SetBool ("bmain", false);
		}
		else if (Input.GetKey (c3)&& mainscript.playercount==0 && mainscript.player==2 && mainscript.destroyedships[2]==0) {
			anim.SetBool ("bship23", true);
			anim.SetBool ("bship22", false);
			anim.SetBool ("bship21", false);
			anim.SetBool ("bship24", false);
			anim.SetBool ("bship14", false);
			anim.SetBool ("bship12", false);
			anim.SetBool ("bship13", false);
			anim.SetBool ("bship11", false);
			anim.SetBool ("bmain", false);
		}
		else if (Input.GetKey (c4)&& mainscript.playercount==0 && mainscript.player==2 && mainscript.destroyedships[3]==0) {
			anim.SetBool ("bship24", true);
			anim.SetBool ("bship22", false);
			anim.SetBool ("bship23", false);
			anim.SetBool ("bship21", false);
			anim.SetBool ("bship14", false);
			anim.SetBool ("bship12", false);
			anim.SetBool ("bship13", false);
			anim.SetBool ("bship11", false);
			anim.SetBool ("bmain", false);
		}
		
		else if(Input.GetKey (shot) && mainscript.playercount==4 && mainscript.player==1 && mainscript.enemyship==1)
		{
			transform.GetComponent.<AudioSource>().Play();
			anim.SetBool ("bmain", false);
			anim.SetBool ("bship14", false);
			anim.SetBool ("bship12", false);
			anim.SetBool ("bship13", false);
			anim.SetBool ("bship11", false);
			anim.SetBool ("bship24", false);
			anim.SetBool ("bship22", false);
			anim.SetBool ("bship23", false);
			anim.SetBool ("bship21", true);
			}
		else if(Input.GetKey (shot) && mainscript.playercount==4 && mainscript.player==1 && mainscript.enemyship==2)
		{
			transform.GetComponent.<AudioSource>().Play();
			anim.SetBool ("bmain", false);
			anim.SetBool ("bship14", false);
			anim.SetBool ("bship12", false);
			anim.SetBool ("bship13", false);
			anim.SetBool ("bship11", false);
			anim.SetBool ("bship24", false);
			anim.SetBool ("bship22", true);
			anim.SetBool ("bship23", false);
			anim.SetBool ("bship21", false);
			}
		else if(Input.GetKey (shot) && mainscript.playercount==4 && mainscript.player==1 && mainscript.enemyship==3)
		{
			transform.GetComponent.<AudioSource>().Play();
			anim.SetBool ("bmain", false);
			anim.SetBool ("bship14", false);
			anim.SetBool ("bship12", false);
			anim.SetBool ("bship13", false);
			anim.SetBool ("bship11", false);
			anim.SetBool ("bship24", false);
			anim.SetBool ("bship22", false);
			anim.SetBool ("bship23", true);
			anim.SetBool ("bship21", false);
			}
		else if(Input.GetKey (shot) && mainscript.playercount==4 && mainscript.player==1 && mainscript.enemyship==4)
		{
			transform.GetComponent.<AudioSource>().Play();
			anim.SetBool ("bmain", false);
			anim.SetBool ("bship14", false);
			anim.SetBool ("bship12", false);
			anim.SetBool ("bship13", false);
			anim.SetBool ("bship11", false);
			anim.SetBool ("bship24", true);
			anim.SetBool ("bship22", false);
			anim.SetBool ("bship23", false);
			anim.SetBool ("bship21", false);
			}
		else if(Input.GetKey (turn) && mainscript.playercount==0 && mainscript.player==1 )
		{
			anim.SetBool ("bmain", true);
			anim.SetBool ("bship14", false);
			anim.SetBool ("bship12", false);
			anim.SetBool ("bship13", false);
			anim.SetBool ("bship11", false);
			anim.SetBool ("bship24", false);
			anim.SetBool ("bship22", false);
			anim.SetBool ("bship23", false);
			anim.SetBool ("bship21", false);
			}
		else if(Input.GetKey (shot) && mainscript.playercount==4 && mainscript.player==2 && mainscript.enemyship==1)
		{
			transform.GetComponent.<AudioSource>().Play();
			anim.SetBool ("bmain", false);
			anim.SetBool ("bship14", false);
			anim.SetBool ("bship12", false);
			anim.SetBool ("bship13", false);
			anim.SetBool ("bship11", true);
			anim.SetBool ("bship24", false);
			anim.SetBool ("bship22", false);
			anim.SetBool ("bship23", false);
			anim.SetBool ("bship21", false);
			}
		else if(Input.GetKey (shot) && mainscript.playercount==4 && mainscript.player==2 && mainscript.enemyship==2)
		{
			transform.GetComponent.<AudioSource>().Play();
			anim.SetBool ("bmain", false);
			anim.SetBool ("bship14", false);
			anim.SetBool ("bship12", true);
			anim.SetBool ("bship13", false);
			anim.SetBool ("bship11", false);
			anim.SetBool ("bship24", false);
			anim.SetBool ("bship22", false);
			anim.SetBool ("bship23", false);
			anim.SetBool ("bship21", false);
			}
		else if(Input.GetKey (shot) && mainscript.playercount==4 && mainscript.player==2 && mainscript.enemyship==3)
		{
			transform.GetComponent.<AudioSource>().Play();
			anim.SetBool ("bmain", false);
			anim.SetBool ("bship14", false);
			anim.SetBool ("bship12", false);
			anim.SetBool ("bship13", true);
			anim.SetBool ("bship11", false);
			anim.SetBool ("bship24", false);
			anim.SetBool ("bship22", false);
			anim.SetBool ("bship23", false);
			anim.SetBool ("bship21", false);
			}
		else if(Input.GetKey (shot) && mainscript.playercount==4 && mainscript.player==2 && mainscript.enemyship==4)
		{
			transform.GetComponent.<AudioSource>().Play();
			anim.SetBool ("bmain", false);
			anim.SetBool ("bship14", true);
			anim.SetBool ("bship12", false);
			anim.SetBool ("bship13", false);
			anim.SetBool ("bship11", false);
			anim.SetBool ("bship24", false);
			anim.SetBool ("bship22", false);
			anim.SetBool ("bship23", false);
			anim.SetBool ("bship21", false);
			}
		else if(Input.GetKey (turn) && mainscript.playercount==0 && mainscript.player==2 )
		{
			anim.SetBool ("bmain", true);
			anim.SetBool ("bship14", false);
			anim.SetBool ("bship12", false);
			anim.SetBool ("bship13", false);
			anim.SetBool ("bship11", false);
			anim.SetBool ("bship24", false);
			anim.SetBool ("bship22", false);
			anim.SetBool ("bship23", false);
			anim.SetBool ("bship21", false);
			}

}