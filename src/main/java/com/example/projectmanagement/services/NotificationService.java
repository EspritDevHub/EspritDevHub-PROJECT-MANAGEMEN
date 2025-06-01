package com.example.projectmanagement.services;

import com.example.projectmanagement.Entities.Tache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private JavaMailSender mailSender;

    /**
     * Envoie un email simple à l'utilisateur
     */
    public void sendEmail(String to, String subject, String body) {
        try {
            if (to == null || to.isEmpty()) {
                System.err.println("L'adresse e-mail du destinataire est vide ou nulle.");
                return;
            }

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject(subject);
            message.setText(body);
            mailSender.send(message);

            System.out.println("✅ Email envoyé à : " + to);
        } catch (Exception e) {
            System.err.println("❌ Erreur lors de l'envoi du mail : " + e.getMessage());
        }
    }

    /**
     * Compare l'ancienne tâche et la nouvelle, et notifie en cas de changement
     */
    public void notifierChangementTache(Tache ancienne, Tache nouvelle) {
        String nouvelEmail = nouvelle.getAssigneA();
        String ancienEmail = ancienne.getAssigneA();

        if (nouvelEmail == null || nouvelEmail.isEmpty()) {
            System.err.println("❌ Aucun email pour l'utilisateur assigné à la tâche.");
            return;
        }

        // Vérifie changement de statut
        if (!ancienne.getEtat().equals(nouvelle.getEtat())) {
            sendEmail(nouvelEmail,
                    "Changement de statut de votre tâche",
                    "Bonjour,\n\nLe statut de la tâche '" + nouvelle.getTitre() +
                            "' a changé de " + ancienne.getEtat() + " à " + nouvelle.getEtat() + ".\n\nCordialement.");
        }

        // Vérifie changement d'assignation
        if (ancienEmail != null && !ancienEmail.equals(nouvelEmail)) {
            sendEmail(nouvelEmail,
                    "Nouvelle tâche assignée",
                    "Bonjour,\n\nUne nouvelle tâche vous a été assignée : '" + nouvelle.getTitre() + "'.\n\nCordialement.");
        }
    }
}
