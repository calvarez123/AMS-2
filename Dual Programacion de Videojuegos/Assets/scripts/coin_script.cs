using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class coin_script : MonoBehaviour

    
{
    
    float timer;
    float interval = 2f;

    public float spawnRadius = 5.0f;

    public GameObject moneda;
    // Start is called before the first frame update
    void Start()
    {
        
        
    }


    private void OnTriggerEnter2D(Collider2D other)
    {
        if (other.CompareTag("Player"))
        {
            // El jugador tocó la moneda, así que la destruimos.
            Debug.Log("Gotcha ");
            gameObject.SetActive(false);

            // Mantenemos la misma posición en Y y generamos una nueva posición en X.
            Vector3 currentPosition = transform.position;
            Vector3 randomPosition = new Vector3(Random.Range(-10f, 10f), currentPosition.y, 0f);
            Instantiate(moneda, transform.position, Quaternion.identity);

        }
    }

    // Update is called once per frame
    void Update()
    {
        
    }
}
