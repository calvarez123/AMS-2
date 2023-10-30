using System.Collections;
using System.Collections.Generic;
using UnityEditor;
using UnityEngine;

public class NewBehaviourScript : MonoBehaviour
{   
    // Start is called before the first frame update   
    Animator animator;
    public float speed =30.0f ;
    public float forceAmount = 10f;
    public bool agachado = false;
    private bool Grounded;
    private Rigidbody2D rb2d;


    private SpriteRenderer spriteRenderer;

    private void OnCollisionEnter2D(Collision2D collision)
    {
        
        if (collision.transform.tag == "Ground"){
            Grounded = true;
        }
        
    }
    private void OnCollisionExit2D(Collision2D collision)
    {
        
        if (collision.transform.tag == "Ground"){
            Grounded = false;
        }
        
    }


    void Start()
    {
        rb2d = GetComponent<Rigidbody2D>();
        animator=GetComponent<Animator>();
        spriteRenderer = GetComponent<SpriteRenderer>();
    }
    

    void Update()
    {
        float horizontalInput = Input.GetAxis("Horizontal");
        float verticalInput = Input.GetAxis("Vertical");
        /*
        Vector2 direction = new Vector2(horizontalInput,verticalInput);
        transform.Translate(direction * speed * Time.deltaTime);
        */
        
        float moveHorizontal = Input.GetAxis("Horizontal");
        Vector2 movement = new Vector2(moveHorizontal, 0);
        rb2d.AddForce(movement * speed);
        
        if (Input.GetKeyDown(KeyCode.UpArrow) && Grounded)
    {
        // Aplicar fuerza hacia arriba para el salto
        rb2d.AddForce(Vector2.up * 5, ForceMode2D.Impulse);
    }   
    
   
    


        
        if (horizontalInput > 0) {
            
            animator.SetBool("walk",true);
            spriteRenderer.flipX = false;
            

        }else if(horizontalInput < 0) {
            // movimiento izquierda
            animator.SetBool("walk",true);
            spriteRenderer.flipX = true;
            
        
        }else{
            animator.SetBool("walk",false);
        }

        if (verticalInput > 0) {
            
            animator.SetBool("isJumping",true);
            

        }else{
            animator.SetBool("isJumping",false);
        }

        if (verticalInput < 0) {
            
            animator.SetBool("isCrouching",true);
            

        }else{
            animator.SetBool("isCrouching",false);
        }

        
      

    }
}

