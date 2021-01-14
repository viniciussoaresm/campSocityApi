package br.com.campsocity.services;

import br.com.campsocity.pojo.Player;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class PlayerService {

    public static final String COL_NAME="players";

    public String save(Player player) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(player.getDocument()).set(player);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public Player get(String playerDocument) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(playerDocument);
        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot document = future.get();

        Player player = null;

        if(document.exists()) {
            player = document.toObject(Player.class);
            return player;
        }else {
            return null;
        }
    }

    public String update(Player player) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(player.getDocument()).set(player);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public String delete(String playerDocument) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection(COL_NAME).document(playerDocument).delete();
        return "Document with Patient ID "+playerDocument+" has been deleted";
    }

}