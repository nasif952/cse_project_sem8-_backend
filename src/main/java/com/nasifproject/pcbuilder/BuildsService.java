package com.nasifproject.pcbuilder;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuildsService {
    @Autowired
    // we want the framework to instantiate this class here for us
    private BuildsRepository buildsRepository;
    public List<PcBuilds> allBuilds(){
        return buildsRepository.findAll();
        // findALl is defined in mongo repository class

    }


    @Autowired
    private MongoTemplate mongoTemplate;

    //manually to add buildlinks
    public void addBuildLinksToAllBuilds() {
        // Check if any document without the buildlinks field exists
        Query query = new Query();
        query.addCriteria(Criteria.where("buildlinks").exists(false));
        long count = mongoTemplate.count(query, PcBuilds.class);
        if (count > 0) { // If any document without the buildlinks field exists, then update
            Update update = new Update();
            update.set("buildlinks", "https://www.youtube.com/watch?v=XbqICngdtH8");
            mongoTemplate.updateMulti(new Query(), update, PcBuilds.class);
            System.out.println("Updated buildlinks for all PcBuilds documents.");
        } else {
            System.out.println("All PcBuilds documents already have buildlinks. No update needed.");
        }
    }

    public PcBuilds addBuild(PcBuilds build){

        return buildsRepository.save(build);
    }

    // optional used , if it responds with no id , then wont cause error(suppose database has no id to return
    public Optional<PcBuilds> SingleBuild(String buildid){

        return buildsRepository.findPcBuildsBybuildid(buildid);
    }

    //////////////////////////////////////////////////////////////////////////
    public Optional<PcBuilds> updateBuild(String buildid, PcBuilds buildDetails) {
        Optional<PcBuilds> existingBuild = buildsRepository.findPcBuildsBybuildid(buildid);
        if (existingBuild.isPresent()) {
            PcBuilds updatedBuild = existingBuild.get();
            updatedBuild.setCost(buildDetails.getCost());
            updatedBuild.setBuild_category(buildDetails.getBuild_category());
            updatedBuild.setCPU(buildDetails.getCPU());

            //buildid
            updatedBuild.setBuildid(buildDetails.getBuildid());
            //ram
            updatedBuild.setRam(buildDetails.getRam());
            //gpu
            updatedBuild.setGpu(buildDetails.getGpu());
            //monitor
            updatedBuild.setMonitor(buildDetails.getMonitor());
            //storage
            updatedBuild.setStorage(buildDetails.getStorage());
            //psu
            updatedBuild.setPsu(buildDetails.getPsu());
            //info
            updatedBuild.setInfo(buildDetails.getInfo());
            //poster
            updatedBuild.setPoster(buildDetails.getPoster());
            //buildname
            updatedBuild.setBuildname(buildDetails.getBuildname());
            //details
            updatedBuild.setDetails(buildDetails.getDetails());
            //backdrops
            updatedBuild.setBackdrops(buildDetails.getBackdrops());
            //reviewIds (notsure)
            //buildlinks
            updatedBuild.setBuildlinks(buildDetails.getBuildlinks());







            return Optional.of(buildsRepository.save(updatedBuild));
        }
        return Optional.empty();
    }

    public void deleteBuild(String buildid) {
        buildsRepository.findPcBuildsBybuildid(buildid).ifPresent(buildsRepository::delete);
    }
    //////////////////////////////////////////////////////////////////////////
}