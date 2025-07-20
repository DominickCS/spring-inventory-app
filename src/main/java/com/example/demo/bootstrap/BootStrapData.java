package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.InhousePartService;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import com.fasterxml.jackson.databind.deser.std.MapEntryDeserializer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public class BootStrapData implements CommandLineRunner {

  private final PartRepository partRepository;
  private final ProductRepository productRepository;

  private final OutsourcedPartRepository outsourcedPartRepository;
  private final InhousePartRepository inhousePartRepository;

  public BootStrapData(PartRepository partRepository, ProductRepository productRepository,
      OutsourcedPartRepository outsourcedPartRepository, InhousePartRepository inhousePartRepository) {
    this.partRepository = partRepository;
    this.productRepository = productRepository;
    this.outsourcedPartRepository = outsourcedPartRepository;
    this.inhousePartRepository = inhousePartRepository;
  }

  @Override
  public void run(String... args) throws Exception {

    // Check to see if the part repository is empty
    if (partRepository.count() == 0) {
      System.out.println("Part Repository is empty!");

      // SAMPLE PART CREATION

      // Create and save inhousepart 'inHouseCase'
      InhousePart inHouseCase = new InhousePart();
      inHouseCase.setName("ATX Computer Case");
      inHouseCase.setPrice(65.00);
      inHouseCase.setInv(19);
      inHouseCase.setPartId(1);
      inHouseCase.setMinInv(10);
      inHouseCase.setMaxInv(30);
      inhousePartRepository.save(inHouseCase);

      // Create and save inhousepart 'inHousePowerSupply'
      InhousePart inHousePowerSupply = new InhousePart();
      inHousePowerSupply.setName("750W Power Supply (Fully Modular)");
      inHousePowerSupply.setPrice(95.00);
      inHousePowerSupply.setInv(7);
      inHousePowerSupply.setPartId(2);
      inHousePowerSupply.setMinInv(20);
      inHousePowerSupply.setMaxInv(60);
      inhousePartRepository.save(inHousePowerSupply);

      // Create and save inhousepart 'inHouseWIFIMotherboard'
      InhousePart inHouseWIFIMotherboard = new InhousePart();
      inHouseWIFIMotherboard.setName("ATX Motherboard (WIFI Model)");
      inHouseWIFIMotherboard.setPrice(160.00);
      inHouseWIFIMotherboard.setInv(4);
      inHouseWIFIMotherboard.setPartId(3);
      inHouseWIFIMotherboard.setMinInv(8);
      inHouseWIFIMotherboard.setMaxInv(12);
      inhousePartRepository.save(inHouseWIFIMotherboard);

      // Create and save inhousepart 'inHouseETHMotherboard'
      InhousePart inHouseETHMotherboard = new InhousePart();
      inHouseETHMotherboard.setName("ATX Motherboard (non-WIFI Model)");
      inHouseETHMotherboard.setPrice(120.00);
      inHouseETHMotherboard.setInv(8);
      inHouseETHMotherboard.setPartId(4);
      inHouseETHMotherboard.setMinInv(10);
      inHouseETHMotherboard.setMaxInv(20);
      inhousePartRepository.save(inHouseETHMotherboard);

      // Create and save outsourcedpart 'outSourcedHERAM'
      OutsourcedPart outSourcedHERAM = new OutsourcedPart();
      outSourcedHERAM.setCompanyName("Crucial");
      outSourcedHERAM.setName("32GB (2x16GB) DDR5 Memory");
      outSourcedHERAM.setPrice(220.00);
      outSourcedHERAM.setInv(3);
      outSourcedHERAM.setMinInv(4);
      outSourcedHERAM.setMaxInv(8);
      outsourcedPartRepository.save(outSourcedHERAM);

      // Create and save outsourcedpart 'outSourcedMERAM'
      OutsourcedPart outSourcedMERAM = new OutsourcedPart();
      outSourcedMERAM.setCompanyName("Crucial");
      outSourcedMERAM.setName("16GB (2x8GB) DDR5 Memory");
      outSourcedMERAM.setPrice(170.00);
      outSourcedMERAM.setInv(9);
      outSourcedMERAM.setMinInv(10);
      outSourcedMERAM.setMaxInv(15);
      outsourcedPartRepository.save(outSourcedMERAM);

      // Create and save outsourcedpart 'outSourcedLERAM'
      OutsourcedPart outSourcedLERAM = new OutsourcedPart();
      outSourcedLERAM.setCompanyName("Crucial");
      outSourcedLERAM.setName("8GB DDR5 Memory");
      outSourcedLERAM.setPrice(110.00);
      outSourcedLERAM.setInv(14);
      outSourcedLERAM.setMinInv(10);
      outSourcedLERAM.setMaxInv(25);
      outsourcedPartRepository.save(outSourcedLERAM);

      // Create and save outsourcedpart 'outSourcedHEGPU'
      OutsourcedPart outSourcedHEGPU = new OutsourcedPart();
      outSourcedHEGPU.setCompanyName("NVIDIA");
      outSourcedHEGPU.setName("RTX 5090");
      outSourcedHEGPU.setPrice(3499.99);
      outSourcedHEGPU.setInv(5);
      outSourcedHEGPU.setMinInv(3);
      outSourcedHEGPU.setMaxInv(8);
      outsourcedPartRepository.save(outSourcedHEGPU);

      // Create and save outsourcedpart 'outSourcedMEGPU'
      OutsourcedPart outsourcedMEGPU = new OutsourcedPart();
      outsourcedMEGPU.setCompanyName("NVIDIA");
      outsourcedMEGPU.setName("RTX 5070");
      outsourcedMEGPU.setPrice(749.99);
      outsourcedMEGPU.setInv(16);
      outsourcedMEGPU.setMinInv(12);
      outsourcedMEGPU.setMaxInv(24);
      outsourcedPartRepository.save(outsourcedMEGPU);

      // Create and save outsourcedpart 'outSourcedLEGPU'
      OutsourcedPart outSourcedLEGPU = new OutsourcedPart();
      outSourcedLEGPU.setCompanyName("NVIDIA");
      outSourcedLEGPU.setName("RTX 5060");
      outSourcedLEGPU.setPrice(349.00);
      outSourcedLEGPU.setInv(32);
      outSourcedLEGPU.setMinInv(25);
      outSourcedLEGPU.setMaxInv(50);
      outsourcedPartRepository.save(outSourcedLEGPU);

      // Create and save outsourcedpart 'outsourcedSSD'
      OutsourcedPart outSourcedSSD = new OutsourcedPart();
      outSourcedSSD.setName("1TB Samsung SA6TA SSD");
      outSourcedSSD.setPrice(89.99);
      outSourcedSSD.setInv(14);
      outSourcedSSD.setMinInv(30);
      outSourcedSSD.setMaxInv(75);
      outsourcedPartRepository.save(outSourcedSSD);

      // Create and save outsourcedpart 'outsourcedNVME'
      OutsourcedPart outSourcedNVME = new OutsourcedPart();
      outSourcedNVME.setName("4TB Samsung 980EVO NVME M.2");
      outSourcedNVME.setPrice(349.99);
      outSourcedNVME.setInv(11);
      outSourcedNVME.setMinInv(20);
      outSourcedNVME.setMaxInv(40);
      outsourcedPartRepository.save(outSourcedNVME);
    }

    if (productRepository.count() == 0) {

      // SAMPLE PRODUCT CREATION
      // Create and save new prouduct 'HEBUILD'

      Product HEBUILD = new Product("High-End Desktop", 6499.99, 7);
      productRepository.save(HEBUILD);

      // Create and save new product 'MEBUILDWIFI'

      Product MEBUILDWIFI = new Product("Middle-End Desktop (WiFi built-in)", 3999.00, 12);
      productRepository.save(MEBUILDWIFI);

      // Create and save new product 'LEBUILDWIFI'

      Product LEBUILDWIFI = new Product("Low-End Desktop (WiFi built-in)", 1999.99, 19);
      productRepository.save(LEBUILDWIFI);

      // Create and save new product 'MEBUILD'

      Product MEBUILD = new Product("Middle-End Desktop", 2499.00, 16);
      productRepository.save(MEBUILD);

      // Create and save new product 'LEBUILD'

      Product LEBUILD = new Product("Low-End Desktop", 1299.99, 33);
      productRepository.save(LEBUILD);
    }

    // Print Number of parts and products in sample inventory
    System.out.println("Number of Products: " + productRepository.count());
    System.out.println("Number of Parts: " + partRepository.count());
  }
}
