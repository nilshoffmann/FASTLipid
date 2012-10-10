/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.ebi.lipidhome.fastlipid.exec;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import junit.framework.TestCase;
import uk.ac.ebi.lipidhome.fastlipid.counter.BooleanRBCounterStartSeeder;
import uk.ac.ebi.lipidhome.fastlipid.generator.ChainFactoryGenerator;
import uk.ac.ebi.lipidhome.fastlipid.generator.GeneralIsomersGenerator;
import uk.ac.ebi.lipidhome.fastlipid.structure.*;
import uk.ac.ebi.lipidhome.fastlipid.structure.rule.BondDistance3nPlus2Rule;
import uk.ac.ebi.lipidhome.fastlipid.structure.rule.BondRule;
import uk.ac.ebi.lipidhome.fastlipid.structure.rule.StarterDoubleBondRule;

/**
 *
 * @author pmoreno
 */
public class GeneralIterativePhospholipidGetterTest extends TestCase {
    
    public GeneralIterativePhospholipidGetterTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of run method, of class GeneralIterativePhospholipidGetter.
     *
    public void testRun() {
        System.out.println("run");
        GeneralIterativePhospholipidGetter instance = new GeneralIterativePhospholipidGetter();
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nextChemInfoContainer method, of class GeneralIterativePhospholipidGetter.
     *
    public void testNextChemInfoContainer() {
        System.out.println("nextChemInfoContainer");
        GeneralIterativePhospholipidGetter instance = new GeneralIterativePhospholipidGetter();
        ChemInfoContainer expResult = null;
        ChemInfoContainer result = instance.nextChemInfoContainer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of configForSmilesOutput method, of class GeneralIterativePhospholipidGetter.
     *
    public void testConfigForSmilesOutput() {
        System.out.println("configForSmilesOutput");
        GeneralIterativePhospholipidGetter instance = new GeneralIterativePhospholipidGetter();
        instance.configForSmilesOutput();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of configForMassAndFormula method, of class GeneralIterativePhospholipidGetter.
     *
    public void testConfigForMassAndFormula() {
        System.out.println("configForMassAndFormula");
        GeneralIterativePhospholipidGetter instance = new GeneralIterativePhospholipidGetter();
        instance.configForMassAndFormula();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCarbonsPerChains method, of class GeneralIterativePhospholipidGetter.
     *
    public void testSetCarbonsPerChains() {
        System.out.println("setCarbonsPerChains");
        Integer[] carbonsChains = null;
        GeneralIterativePhospholipidGetter instance = new GeneralIterativePhospholipidGetter();
        instance.setCarbonsPerChains(carbonsChains);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setChemInfoContainerGenerator method, of class GeneralIterativePhospholipidGetter.
     *
    public void testSetChemInfoContainerGenerator() {
        System.out.println("setChemInfoContainerGenerator");
        ChemInfoContainerGenerator chemInfoContainerGenerator = null;
        GeneralIterativePhospholipidGetter instance = new GeneralIterativePhospholipidGetter();
        instance.setChemInfoContainerGenerator(chemInfoContainerGenerator);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGenerator method, of class GeneralIterativePhospholipidGetter.
     *
    public void testSetGenerator() {
        System.out.println("setGenerator");
        GeneralIsomersGeneratorDefinedFattyAcids generator = null;
        GeneralIterativePhospholipidGetter instance = new GeneralIterativePhospholipidGetter();
        instance.setGenerator(generator);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGenerateChainInfoContainer method, of class GeneralIterativePhospholipidGetter.
     *
    public void testSetGenerateChainInfoContainer() {
        System.out.println("setGenerateChainInfoContainer");
        boolean generateChainInfoContainer = false;
        GeneralIterativePhospholipidGetter instance = new GeneralIterativePhospholipidGetter();
        instance.setGenerateChainInfoContainer(generateChainInfoContainer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumOfTotalStructures method, of class GeneralIterativePhospholipidGetter.
     *
    public void testGetNumOfTotalStructures() {
        System.out.println("getNumOfTotalStructures");
        GeneralIterativePhospholipidGetter instance = new GeneralIterativePhospholipidGetter();
        int expResult = 0;
        int result = instance.getNumOfTotalStructures();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class GeneralIterativePhospholipidGetter.
     */
    public void testMain() {
        System.out.println("main");
                int carbonsA=12;
        int carbonsB=14;
        int dbA=3;
        int dbB=2;
        
        List<BondRule> rules = Arrays.asList(new BondDistance3nPlus2Rule(), new StarterDoubleBondRule(2));
        ChainFactoryGenerator cfg = new ChainFactoryGenerator(rules, new BooleanRBCounterStartSeeder(rules), true);

        GeneralIterativePhospholipidGetter ipgdcdbpc = new GeneralIterativePhospholipidGetter(cfg);
        ipgdcdbpc.setCarbonsPerChains(carbonsA, carbonsB);
        ipgdcdbpc.setDoubleBondsPerChains(dbA,dbB);
        ipgdcdbpc.setHeadGroup(HeadGroup.PC);
        ipgdcdbpc.configForSmilesOutput();
        ipgdcdbpc.setGenerateChainInfoContainer(true);
        ipgdcdbpc.setLinkConfigs(SingleLinkConfiguration.Acyl, SingleLinkConfiguration.Acyl);
        ipgdcdbpc.run();

        ChemInfoContainer res = ipgdcdbpc.nextChemInfoContainer();

        while(res!=null) {
            System.out.println("Smiles:"+res.getSmiles());
            int count=1;
            for (ChainInfoContainer chainInfo : res.getChainsInfo()) {
                System.out.println("Chain "+count+": Double bonds in pos:");
                count++;
                for (Integer integer : chainInfo.getDoubleBondPositions()) {
                    System.out.print(integer+" ");
                }
                System.out.println();
            }
            System.out.println("Exact mass:"+res.getExactMass());
            System.out.println("Natural mass:"+res.getNaturalMass());
            res = ipgdcdbpc.nextChemInfoContainer();
        }

        System.out.println("Total:"+ipgdcdbpc.getNumOfTotalStructures());
    }

    /**
     * Test of setLinkConfigs method, of class GeneralIterativePhospholipidGetter.
     *
    public void testSetLinkConfigs() {
        System.out.println("setLinkConfigs");
        SingleLinkConfiguration[] confR1 = {SingleLinkConfiguration.Acyl, SingleLinkConfiguration.Alkyl};
        GeneralIterativePhospholipidGetter instance = new GeneralIterativePhospholipidGetter();
        instance.setLinkConfigs(confR1);
    }
    */
    public void testInitWithSubSpecies() {
        List<BondRule> rules = Arrays.asList(new BondDistance3nPlus2Rule(), new StarterDoubleBondRule(2));
        GeneralIsomersGetterForCarbonsAndDoubleBonds gigfcadb = new GeneralIsomersGetterForCarbonsAndDoubleBonds();
        //gigfcadb.setGenerator(new GeneralIsomersGenerator());
        gigfcadb.configForSmilesOutput();
        gigfcadb.setCarbons(30);
        gigfcadb.setDoubleBonds(3);
        ChainFactoryGenerator cfg = new ChainFactoryGenerator(rules, new BooleanRBCounterStartSeeder(rules), true);
        gigfcadb.setChainFactoryGenerator(cfg);
        gigfcadb.setHead(HeadGroup.PC);
        gigfcadb.setLinkConfigs(SingleLinkConfiguration.Acyl, SingleLinkConfiguration.Alkyl);
                
        gigfcadb.exec();
        
        Iterator<SubSpecies> subSpIt = gigfcadb.getSupSpeciesIterator();
        while(subSpIt.hasNext()) {
            SubSpecies sp = subSpIt.next();
            GeneralIterativePhospholipidGetter gipg = new GeneralIterativePhospholipidGetter(sp, cfg);
            ChemInfoContainerGenerator gen = new ChemInfoContainerGenerator();
            gen.setGenerateSmiles(Boolean.TRUE);
            gen.setGenerateChainInfoContainers(true);
            gen.setGenerateCDKMol(true);
            gipg.setChemInfoContainerGenerator(gen);
            gipg.run();
            
            System.out.println("Config : "+sp.getFattyAcids().toString());
            while(true) {
                ChemInfoContainer cic = gipg.nextChemInfoContainer();
                if(cic==null)
                    break;
                System.out.println("Atom count: "+cic.getCDKMolecule().getAtomCount());
                System.out.println(cic.getSmiles());
            }
        }
        
    }
    
    public void testInitWithIsomerInfoContainer() {
        SpeciesInfoContainer cont = new SpeciesInfoContainer();
        cont.setNumOfCarbons(30);
        cont.setNumOfDoubleBonds(3);
        cont.setHeadGroup(HeadGroup.PC);
        cont.setLinkers(Arrays.asList(SingleLinkConfiguration.Acyl,SingleLinkConfiguration.Alkyl));
        
        List<BondRule> rules = Arrays.asList(new BondDistance3nPlus2Rule(), new StarterDoubleBondRule(2));
        
        GeneralIsomersGetterForCarbonsAndDoubleBonds gigfcadb = new GeneralIsomersGetterForCarbonsAndDoubleBonds(cont);
        //gigfcadb.configForSmilesOutput();
        ChainFactoryGenerator cfg = new ChainFactoryGenerator(rules, new BooleanRBCounterStartSeeder(rules), true);
        gigfcadb.setChainFactoryGenerator(cfg);
                
        gigfcadb.exec();
        
        Iterator<SubSpecies> subSpIt = gigfcadb.getSupSpeciesIterator();
        while(subSpIt.hasNext()) {
            SubSpecies sp = subSpIt.next();
            GeneralIterativePhospholipidGetter gipg = new GeneralIterativePhospholipidGetter(sp, cfg);
            ChemInfoContainerGenerator gen = new ChemInfoContainerGenerator();
            gen.setGenerateSmiles(Boolean.TRUE);
            gen.setGenerateChainInfoContainers(true);
            gen.setGenerateCDKMol(true);
            gipg.setChemInfoContainerGenerator(gen);
            gipg.run();
            
            System.out.println("Config : "+sp.getFattyAcids().toString());
            while(true) {
                ChemInfoContainer cic = gipg.nextChemInfoContainer();
                if(cic==null)
                    break;
                System.out.println("Atom count: "+cic.getCDKMolecule().getAtomCount());
                System.out.println(cic.getSmiles());
            }
        }
        
    }
}
