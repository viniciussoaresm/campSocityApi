package br.com.campsocity.services;

import br.com.campsocity.pojo.Player;
import br.com.campsocity.pojo.Team;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class TeamService {

    public static final String COL_NAME="teams";

    public String save(Team team) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(team.getToken()).set(team);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public Team get(String token) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(token);
        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot document = future.get();

        Team team = null;

        if(document.exists()) {
            team = document.toObject(Team.class);
            return team;
        }else {
            return null;
        }
    }

    public String update(Team team) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(team.getToken()).set(team);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public String delete(String token) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection(COL_NAME).document(token).delete();
        return "Document with Patient ID "+token+" has been deleted";
    }

}