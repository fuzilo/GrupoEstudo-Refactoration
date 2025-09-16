package grupo.estudos.ingressoservice.service;

import grupo.estudos.ingressoservice.model.Invoice;
import grupo.estudos.ingressoservice.model.Performance;
import grupo.estudos.ingressoservice.model.Play;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

public class StatementGenerator {
    public String statement(Invoice invoice, Play plays) {
        int totalAmount = 0;
        int volumeCredits = 0;
        StringBuilder result = new StringBuilder();
        result.append("Statement for ").append(invoice.getCustomer()).append("\n");

        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);

        for (Performance perf : invoice.getPerformances()) {
            Play play = plays;
            int thisAmount = 0;

            switch (play.getType()) {
                case "tragedy":
                    thisAmount = 40000;
                    if (perf.getAudience() > 30) {
                        thisAmount += 1000 * (perf.getAudience() - 30);
                    }
                    break;
                case "comedy":
                    thisAmount = 30000;
                    if (perf.getAudience() > 20) {
                        thisAmount += 10000 + 500 * (perf.getAudience() - 20);
                    }
                    thisAmount += 300 * perf.getAudience();
                    break;
                default:
                    throw new Error("unknown type: " + play.getType());
            }

            // soma créditos por volume
            volumeCredits += Math.max(perf.getAudience() - 30, 0);

            // soma um crédito extra para cada dez espectadores de comédia
            if ("comedy".equals(play.getType())) {
                volumeCredits += Math.floor(perf.getAudience() / 5);
            }

            // exibe a linha para esta requisição
            result.append("  ")
                    .append(play.getName())
                    .append(": ")
                    .append(format.format(thisAmount / 100.0))
                    .append(" (")
                    .append(perf.getAudience())
                    .append(" seats)\n");

            totalAmount += thisAmount;
        }

        result.append("Amount owed is ").append(format.format(totalAmount / 100.0)).append("\n");
        result.append("You earned ").append(volumeCredits).append(" credits\n");

        return result.toString();
    }
}

