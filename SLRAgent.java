package examples.slr;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.DFService;

public class SLRAgent extends Agent {
	SLRGui myGui;
    SimpleLinearRegression slr;

    protected void setup() {
        System.out.println("Agent " + getLocalName() + " started.");
        slr = new SimpleLinearRegression();
        myGui = new SLRGui(this);
        myGui.showGui();
    }

    public void addValueToPredict(final double xValue) {
        addBehaviour(new OneShotBehaviour() {
            public void action() {
                double yPredicted = 0;
                double dataSetX[] = {23, 26, 30, 34, 43, 48, 52, 57, 58};
                double dataSetY[] = {
                    651,
                    762,
                    856,
                    1063,
                    1190,
                    1298,
                    1421,
                    1440,
                    1518
                };
                slr.calculateBeta(dataSetX, dataSetY);
                yPredicted = slr.makePrediction(xValue);
                System.out.println(String.format("Prediccion con: %.4f", xValue));
                System.out.println(String.format("%.4f", yPredicted));
            }
        });
    }
}