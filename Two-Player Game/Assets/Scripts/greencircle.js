#pragma strict
var anim:Animator;
var c1:KeyCode;
var c2:KeyCode;
var c3:KeyCode;
var c4:KeyCode;
function Start () {
		anim = GetComponent("Animator");
		anim.SetBool ("mainpos", true);
}

function Update () {
if (Input.GetKey (c1) && mainscript.playercount==0 && mainscript.player==1  && mainscript.destroyedships2[0]==0  ) {
			anim.SetBool ("gship1", true);
			anim.SetBool ("gship2", false);
			anim.SetBool ("gship3", false);
			anim.SetBool ("gship4", false);
			anim.SetBool ("mainpos", false);
				}
		else if (Input.GetKey (c2) && mainscript.playercount==0 && mainscript.player==1 && mainscript.destroyedships2[1]==0 ) {
			anim.SetBool ("gship2", true);
			anim.SetBool ("gship1", false);
			anim.SetBool ("gship3", false);
			anim.SetBool ("gship4", false);
			anim.SetBool ("mainpos", false);
		}
		else if (Input.GetKey (c3)&& mainscript.playercount==0 && mainscript.player==1 && mainscript.destroyedships2[2]==0 ) {
			anim.SetBool ("gship3", true);
			anim.SetBool ("gship2", false);
			anim.SetBool ("gship1", false);
			anim.SetBool ("gship4", false);
			anim.SetBool ("mainpos", false);
		}
		else if (Input.GetKey (c4)&& mainscript.playercount==0 && mainscript.player==1 && mainscript.destroyedships2[3]==0 ) {
			anim.SetBool ("gship4", true);
			anim.SetBool ("gship2", false);
			anim.SetBool ("gship3", false);
			anim.SetBool ("gship1", false);
			anim.SetBool ("mainpos", false);
		}
		if (Input.GetKey (c1) && mainscript.playercount==0 && mainscript.player==2 && mainscript.destroyedships[0]==0 ) {
			anim.SetBool ("gship21", true);
			anim.SetBool ("gship22", false);
			anim.SetBool ("gship23", false);
			anim.SetBool ("gship24", false);
			anim.SetBool ("mainpos", false);
				}
		else if (Input.GetKey (c2) && mainscript.playercount==0 && mainscript.player==2 && mainscript.destroyedships[1]==0) {
			anim.SetBool ("gship22", true);
			anim.SetBool ("gship21", false);
			anim.SetBool ("gship23", false);
			anim.SetBool ("gship24", false);
			anim.SetBool ("mainpos", false);
		}
		else if (Input.GetKey (c3)&& mainscript.playercount==0 && mainscript.player==2 && mainscript.destroyedships[2]==0) {
			anim.SetBool ("gship23", true);
			anim.SetBool ("gship22", false);
			anim.SetBool ("gship21", false);
			anim.SetBool ("gship24", false);
			anim.SetBool ("mainpos", false);
		}
		else if (Input.GetKey (c4)&& mainscript.playercount==0 && mainscript.player==2 && mainscript.destroyedships[3]==0) {
			anim.SetBool ("gship24", true);
			anim.SetBool ("gship22", false);
			anim.SetBool ("gship23", false);
			anim.SetBool ("gship21", false);
			anim.SetBool ("mainpos", false);
		}
		else if(mainscript.playercount==4 && mainscript.player==1)
		{
			anim.SetBool ("mainpos", true);
			anim.SetBool ("gship4", false);
			anim.SetBool ("gship2", false);
			anim.SetBool ("gship3", false);
			anim.SetBool ("gship1", false);
			}
			else if(mainscript.playercount==4 && mainscript.player==2)
		{
			anim.SetBool ("mainpos", true);
			anim.SetBool ("gship24", false);
			anim.SetBool ("gship22", false);
			anim.SetBool ("gship23", false);
			anim.SetBool ("gship21", false);
			}

}